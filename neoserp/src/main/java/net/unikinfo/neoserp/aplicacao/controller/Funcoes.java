package net.unikinfo.neoserp.aplicacao.controller;

import br.com.unikinfo.neoserp.comum.viacep.ViaCEP;
import br.com.unikinfo.neoserp.comum.viacep.ViaCEPException;
import br.com.unikinfo.neoserp.controller.util.JsfUtil;
import br.com.unikinfo.neoserp.entidade.Boletobancario;
import br.com.unikinfo.neoserp.entidade.Configuracao;
import br.com.unikinfo.neoserp.entidade.ConfiguracaoPK;
import br.com.unikinfo.neoserp.facade.ConfiguracaoFacade;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialResponseWriter;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Carlos
 */
public class Funcoes implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    ConfiguracaoRepository configuracaoFacade;
    private Funcoes funcoes;
    @PersistenceContext(unitName = "UnikServicosPU")
    EntityManager em;
    public static final String modulo = "Servi�os";
    private int msgBotao;

    @Inject
    private ValidaUsuarioController vu;

    private List<String> TipoProduto;
    private Map<String, String> codigosEstado;

    private static Properties config = new Properties();
    private static String arquivoIni;
    private boolean cfpCnpjValidado;
    private FacesContext fc;
    private String msgTitulo;
    private String msgMensagem;
    private String msgTipo;

    public enum MensagemTipo {
        INFO,
        SUCCESS,
        WARNING,
        ERROR
    }

    public Funcoes() {
        msgTitulo = "";
        msgMensagem = "";
        TipoProduto = new ArrayList<String>();
        TipoProduto = Arrays.asList("SERVICO", "ESTOQUE", "GRUPO", "PRODUCAO", "CARDAPIO", "CARDAPIOGRUPO", "OUTROS");
        codigosEstado = new TreeMap<String, String>();
        codigosEstado.put("11", "11-Rond�nia");
        codigosEstado.put("12", "12-Acre");
        codigosEstado.put("13", "13-Amazonas");
        codigosEstado.put("14", "14-Roraima");
        codigosEstado.put("15", "15-Par�");
        codigosEstado.put("16", "16-Amap�");
        codigosEstado.put("17", "17-Tocantins");
        codigosEstado.put("21", "21-Maranh�o");
        codigosEstado.put("22", "22-Piau�");
        codigosEstado.put("23", "23-Cear�");
        codigosEstado.put("24", "24-Rio Grande do Norte");
        codigosEstado.put("25", "25-Para�ba");
        codigosEstado.put("26", "26-Pernambuco");
        codigosEstado.put("27", "27-Alagoas");
        codigosEstado.put("28", "28-Sergipe");
        codigosEstado.put("29", "29-Bahia");
        codigosEstado.put("31", "31-Minas Gerais");
        codigosEstado.put("32", "32-Esp�rito Santo");
        codigosEstado.put("33", "33-Rio de Janeiro");
        codigosEstado.put("35", "35-S�o Paulo");
        codigosEstado.put("41", "41-Paran�");
        codigosEstado.put("42", "42-Santa Catarina");
        codigosEstado.put("43", "43-Rio Grande do Sul");
        codigosEstado.put("50", "50-Mato Grosso do Sul");
        codigosEstado.put("51", "51-Mato Grosso");
        codigosEstado.put("52", "52-Goi�s");
        codigosEstado.put("53", "53-Distrito Federal");

        HttpServletRequest request;
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance()
                    .getExternalContext().getRequest();
        } catch (Exception e) {
            request = null;
        }
        if (request != null) {
            arquivoIni = request.getSession().getServletContext().getRealPath("/config.properties");
        } else {
            arquivoIni = "./config.properties";
        }

    }

    public Boolean InputStreamToFile(InputStream is, String arquivo) {
        try {
            OutputStream os = new FileOutputStream(arquivo);

            byte[] buffer = new byte[1024];
            int bytesRead;
            //read from is to buffer
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            //is.close();
            //flush OutputStream to write any buffered data to file
            os.flush();
            os.close();
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public String somaAnomes(String pAnomes, int pValor) {
        Integer ano = Integer.valueOf(pAnomes.substring(0, 4));
        Integer mes = Integer.valueOf(pAnomes.substring(4, 6));

        int ate = pValor;
        if (pValor < 0) {
            ate = pValor * -1;
        }

        for (int x = 0; x < ate; x++) {
            if (pValor >= 0) {
                mes++;
            } else {
                mes--;
            }
            if (mes == 13) {
                ano++;
                mes = 1;
            }
            if (mes == 0) {
                ano--;
                mes = 12;
            }
        }
        return rPad(Integer.toString(ano), "0", 4) + rPad(Integer.toString(mes), "0", 2);
    }

//    public List<String> ConsultaCepCorreios(String cep) {
//        List<String> result = new ArrayList<String>();
//        if(cep != null) {
//            try {
//                String urlCorreios = "http://viacep.com.br/ws/" + cep + "/json/";
//                URL url = new URL(urlCorreios);
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setRequestMethod("GET");
//                conn.addRequestProperty(modulo, modulo);
//
//                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                String line;
//                String paraLatin;
//                while ((line = rd.readLine()) != null) {
//                    paraLatin = new String(line.getBytes("latin1"), "utf-8");                                    
//                    result.add(paraLatin);
//                }
//
//            } catch (IOException e) {
//            e.printStackTrace();
//            }
//        }
//        return result;
//    }
    public List<String> ConsultaCepCorreios(String cep) {
        List<String> result = new ArrayList<String>();
        ViaCEP buscaCep = new ViaCEP();
        try {
            buscaCep.buscar(cep);
            result.add("  \"logradouro\" " + buscaCep.getLogradouro());
            result.add("  \"bairro\" " + buscaCep.getBairro());
            result.add("  \"localidade\" " + buscaCep.getLocalidade());
            result.add("  \"uf\" " + buscaCep.getUf());
        } catch (ViaCEPException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public String TiraAcento(String pStr) {
        String result = pStr;
        result = result.replaceAll("�", "a");
        result = result.replaceAll("�", "A");
        result = result.replaceAll("�", "a");
        result = result.replaceAll("�", "A");
        result = result.replaceAll("�", "a");
        result = result.replaceAll("�", "A");
        result = result.replaceAll("�", "c");
        result = result.replaceAll("�", "c");
        result = result.replaceAll("�", "e");
        result = result.replaceAll("�", "E");
        result = result.replaceAll("�", "e");
        result = result.replaceAll("�", "E");
        result = result.replaceAll("�", "e");
        result = result.replaceAll("�", "E");
        result = result.replaceAll("�", "i");
        result = result.replaceAll("�", "I");
        result = result.replaceAll("�", "i");
        result = result.replaceAll("�", "I");
        result = result.replaceAll("�", "o");
        result = result.replaceAll("�", "O");
        result = result.replaceAll("�", "o");
        result = result.replaceAll("�", "O");
        result = result.replaceAll("�", "o");
        result = result.replaceAll("�", "O");

        return result;
    }

    public String TiraCaracter(String pStr) {
        String result = pStr;
        result = result.replaceAll("\"", "");
        result = result.replaceAll("�", "");
        result = result.replaceAll("\\.", "");
        return result;
    }

    public String TiraPontos(String pStr) {
        String result = pStr;
        result = result.replaceAll("\"", "");
        result = result.replaceAll("�", "");
        result = result.replaceAll("\\.", "");
        result = result.replaceAll("-", "");
        return result;
    }

    public String formatDate(Date pDt, String pFormat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pFormat);
        return dateFormat.format(pDt);
    }

    public String formatDate(Calendar pDt, String pFormat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pFormat);
        return dateFormat.format(pDt.getTime());
    }

    public Date strToDate(String pDt, String pFormat) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pFormat);
        return (Date) dateFormat.parse(pDt);
    }

    public String lPad(String pStr, String pChar, int size) {
        if (pStr == null) {
            pStr = "";
        }
        while (pStr.length() < size) {
            pStr = pChar + pStr;
        }
        return pStr.substring(0, size);
    }

    public String rPad(String pStr, String pChar, int size) {
        if (pStr == null) {
            pStr = "";
        }
        while (pStr.length() < size) {
            pStr = pStr + pChar;
        }
        return pStr.substring(0, size);
        //return pStr.substring(pStr.length() - size, pStr.length());
    }

    public String formatNumber(Double pValor, String pMascara) {
        DecimalFormat df = new DecimalFormat(pMascara);
        return df.format(pValor);
    }

    public String formatNumber(Integer pValor, String pMascara) {
        DecimalFormat df = new DecimalFormat(pMascara);
        return df.format(pValor);
    }

    public Date dateTimeToDate(Date pDt) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return strToDate(dateFormat.format(pDt), "yyyy/MM/dd");
    }

    public String getConfiguracao(String chave, String descricao) {
        //System.out.println("Chave:" + chave + " Descricao:" + descricao);
        ConfiguracaoPK confPK = new ConfiguracaoPK();
        confPK.setChave(chave);
        confPK.setDescricao(descricao);

        Configuracao configuracao = new Configuracao();
        configuracao = configuracaoFacade.find(confPK);
        //System.out.println(configuracao);
        return configuracao.getValor();
    }

    public String getSaudacao() {
        Calendar dataHoraAtual = Calendar.getInstance();
        if (dataHoraAtual.get(Calendar.HOUR_OF_DAY) >= 12 && dataHoraAtual.get(Calendar.HOUR_OF_DAY) < 18) {
            return ResourceBundle.getBundle("/BundleServicos_" + vu.getCurrentLocale().toString()).getString("BoaTarde");
        } else if (dataHoraAtual.get(Calendar.HOUR_OF_DAY) >= 18) {
            return ResourceBundle.getBundle("/BundleServicos_" + vu.getCurrentLocale().toString()).getString("BoaNoite");
        } else {
            return ResourceBundle.getBundle("/BundleServicos_" + vu.getCurrentLocale().toString()).getString("BomDia");
        }
    }

    public Date getDataInicioFim(int mes, int ano, Boolean inicioMes) {
        Calendar dt = new GregorianCalendar(ano, mes - 1, 1);
        if (!inicioMes) {
            dt.add(Calendar.MONTH, 1);
            dt.add(Calendar.DAY_OF_MONTH, -1);
        }
        return dt.getTime();
    }

    public Calendar getDataInicioFimCalendar(int mes, int ano, Boolean inicioMes) {
        Calendar dt = new GregorianCalendar(ano, mes - 1, 1);
        if (!inicioMes) {
            dt.add(Calendar.MONTH, 1);
            dt.add(Calendar.DAY_OF_MONTH, -1);
        }
        return dt;
    }

    public String CalculaDigitoBradesco(String Carteira, String NossoNumero) {
        String Digito;
        Digito = Modulo11Base7(lPad(Carteira, "0", 2)
                + lPad(NossoNumero, "0", 11));
        return Digito;
    }

    public String Modulo11Base7(String num) {
        //vari�veis de instancia  
        int soma = 0;
        int resto = 0;
        String dv = "0";
        String[] numeros = new String[num.length() + 1];
        int multiplicador = 2;
        for (int i = num.length(); i > 0; i--) {
            //Multiplica da direita pra esquerda, incrementando o multiplicador de 2 a 9  
            //Caso o multiplicador seja maior que 9 o mesmo recome�a em 2  
            if (multiplicador > 7) {
                // pega cada numero isoladamente    
                multiplicador = 2;
                numeros[i] = String.valueOf(Integer.valueOf(num.substring(i - 1, i)) * multiplicador);
                multiplicador++;
            } else {
                numeros[i] = String.valueOf(Integer.valueOf(num.substring(i - 1, i)) * multiplicador);
                multiplicador++;
            }
        }
        //Realiza a soma de todos os elementos do array e calcula o digito verificador  
        //na base 11 de acordo com a regra.       
        for (int i = numeros.length; i > 0; i--) {
            if (numeros[i - 1] != null) {
                soma += Integer.valueOf(numeros[i - 1]);
            }
        }
        resto = soma % 11;
        dv = Integer.toString(11 - resto);
        if (resto == 0) {
            dv = "0";
        } else if (resto == 1) {
            dv = "P";
        } else if (Integer.parseInt(dv) > 9 || dv.equals("0")) {
            dv = "1";
        }
        //retorna o digito verificador  
        return dv;
    }

    public String Modulo10(String valor) {
        String Auxiliar;
        Integer Cont, Peso;
        Integer Digito;
        Auxiliar = "";
        Peso = 2;

        for (Cont = valor.length() - 1; Cont > 0; Cont--) {
            Integer pos = Integer.parseInt(Character.toString(valor.charAt(Cont)));
            Auxiliar += Integer.toString(pos * Peso);
            if (Peso == 1) {
                Peso = 2;
            } else {
                Peso = 1;
            }

        }
        Digito = 0;
        for (Cont = 0; Cont < Auxiliar.length(); Cont++) {
            Integer pos = Integer.parseInt(Character.toString(Auxiliar.charAt(Cont)));
            Digito = Digito + pos;
        }
        Digito = 10 - (Digito % 10);
        if (Digito > 9) {
            Digito = 0;
        }
        return Integer.toString(Digito);
    }

    public String CalculaDigito(String Agencia, String Conta, String Carteira, String NossoNumero) {
        String Digito;

        Digito = Modulo10(lPad(Agencia, "0", 4)
                + lPad(Conta, "0", 5)
                + lPad(Carteira, "0", 3)
                + lPad(NossoNumero, "0", 8));
        return Digito;
    }

    public String Modulo11Base92(String num) {
        //vari�veis de instancia  
        int soma = 0;
        int resto = 0;
        String dv = "0";
        String[] numeros = new String[num.length() + 1];
        int multiplicador = 2;
        for (int i = num.length(); i > 0; i--) {
            //Multiplica da direita pra esquerda, incrementando o multiplicador de 2 a 9  
            //Caso o multiplicador seja maior que 9 o mesmo recome�a em 2  
            if (multiplicador > 9) {
                // pega cada numero isoladamente    
                multiplicador = 2;
                numeros[i] = String.valueOf(Integer.valueOf(num.substring(i - 1, i)) * multiplicador);
                multiplicador++;
            } else {
                numeros[i] = String.valueOf(Integer.valueOf(num.substring(i - 1, i)) * multiplicador);
                multiplicador++;
            }
        }
        //Realiza a soma de todos os elementos do array e calcula o digito verificador  
        //na base 11 de acordo com a regra.       
        for (int i = numeros.length; i > 0; i--) {
            if (numeros[i - 1] != null) {
                soma += Integer.valueOf(numeros[i - 1]);
            }
        }
        resto = soma % 11;
        dv = Integer.toString(11 - resto);
        if (resto == 0) {
            dv = "0";
        } else if (Integer.parseInt(dv) > 9 || dv.equals("0")) {
            dv = "1";
        }
        //retorna o digito verificador  
        return dv;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            //cria a conexão com o banco de dados 
            Class.forName("com.mysql.jdbc.Driver");
            String db = "jdbc:mysql://localhost:3306/dbUnik?user=root&password=root";
            connection = DriverManager.getConnection(db);
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
        return connection;
    }

    public List<String> getTipoProduto() {
        return TipoProduto;
    }

    public void setTipoProduto(List<String> TipoProduto) {
        this.TipoProduto = TipoProduto;
    }

    public Map<String, String> getCodigosEstado() {
        return codigosEstado;
    }

    public void setCodigosEstado(Map<String, String> codigosEstado) {
        this.codigosEstado = codigosEstado;
    }

    public boolean getCfpCnpjValidado() {
        return cfpCnpjValidado;
    }

    public void setCfpCnpjValidado(boolean cfpCnpjValidado) {
        this.cfpCnpjValidado = cfpCnpjValidado;
    }

    public String lerIni(String pChave) {
        String conteudo = "";
        try {
            config.load(new FileInputStream(arquivoIni));
            conteudo = config.getProperty(pChave, "");
        } catch (IOException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conteudo;
    }

    public String lerDocHtml(String arqDocHtml, Boletobancario bol) {
        String resultado = "";
        String campo = "";
        String resultAlterado = "";
        boolean isField = false;
        Integer pIni = 0;
        Integer pFin = 0;
        System.out.println("caminho: " + arqDocHtml);
        try {
            BufferedReader br = new BufferedReader(new FileReader(arqDocHtml));
            while (br.ready()) {
                resultado += br.readLine();
            }
            resultAlterado = resultado;
            for (int i = 0; i < resultado.length(); i++) {
                char letra = resultado.charAt(i);
                if (letra == '[') {
                    isField = true;
                    pIni = i + 1;
                }
                if (letra == ']') {
                    isField = false;
                    pFin = i;
                    campo = resultado.substring(pIni, pFin);
                    System.out.println("Campo: " + campo);

                    Object value1 = null;

                    if (!campo.isEmpty()) {
                        String metodo1 = "get" + campo.substring(0, 1).toUpperCase() + campo.substring(1);
                        System.out.println("metodo1 : " + metodo1);

                        if (campo.equals("dataAtualPorExtenso")) {
                            value1 = getDataAtualPorExtenso();
                        } else if (campo.equals("cidadeEmpresa")) {
                            if (vu.getEmpresa().getCidadeEmp() != null) {
                                value1 = vu.getEmpresa().getCidadeEmp();
                            } else {
                                value1 = "cidade n�o informada!";
                            }
                        } else {

                            Method m1;

                            try {
                                m1 = bol.getClass().getDeclaredMethod(metodo1);
                                value1 = (Object) m1.invoke(bol);
                                if (value1.getClass().getName().equals("java.util.Date")) {
                                    SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
                                    value1 = dt.format(value1);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            pIni = 0;
                            pFin = 0;
                        }
                        if (value1 != null) {
                            resultAlterado = resultAlterado.replaceAll(campo, value1.toString());
                        }
                    }
                }
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        resultAlterado = resultAlterado.replace("[", " ");
        resultAlterado = resultAlterado.replace("]", " ");
        return resultAlterado;
    }

    public String getDataAtualPorExtenso() {
        String data = "";
        Calendar calendario = Calendar.getInstance();
        Locale localizacao = vu.getCurrentLocale();

        data += Integer.toString(calendario.get(Calendar.DAY_OF_MONTH));
        data += " de " + calendario.getDisplayName(Calendar.MONTH, Calendar.LONG, localizacao).toLowerCase();
        data += " de " + Integer.toString(calendario.get(Calendar.YEAR));

        return data;
    }

    public Date extrairData(Date pDate) {
        Calendar vCalendar = GregorianCalendar.getInstance();
        vCalendar.setTime(pDate);
        Calendar dateCalendar = new GregorianCalendar(vCalendar.get(Calendar.YEAR), vCalendar.get(Calendar.MONTH), vCalendar.get(Calendar.DAY_OF_MONTH));
        return dateCalendar.getTime();
    }

    public Long diferencaData(Date pDate1, Date pDate2) {
        Calendar vCalendar1 = GregorianCalendar.getInstance();
        vCalendar1.setTime(pDate1);
        Calendar vCalendar2 = GregorianCalendar.getInstance();
        vCalendar2.setTime(pDate2);

        LocalDate inicio = LocalDate.of(vCalendar1.get(Calendar.YEAR), vCalendar1.get(Calendar.MONTH) + 1, vCalendar1.get(Calendar.DAY_OF_MONTH));
        LocalDate fim = LocalDate.of(vCalendar2.get(Calendar.YEAR), vCalendar2.get(Calendar.MONTH) + 1, vCalendar2.get(Calendar.DAY_OF_MONTH));
        long retorno = ChronoUnit.DAYS.between(inicio, fim);
        return retorno;
    }

    public Date somaData(Date pDate, Integer dias) {
        Calendar vCalendar = GregorianCalendar.getInstance();
        vCalendar.setTime(pDate);
        vCalendar.add(Calendar.DATE, dias);
        return vCalendar.getTime();

    }

    public boolean validaCPF(String CPF) {
        System.out.println("Entrou Validador!");
// considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            JsfUtil.addErrorMessage("CPF Invalido!");
            this.setCfpCnpjValidado(false);
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
// Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
// converte o i-esimo caractere do CPF em um numero:
// por exemplo, transforma o caractere '0' no inteiro 0         
// (48 eh a posicao de '0' na tabela ASCII)         
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
// Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

// Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                this.setCfpCnpjValidado(true);
                return (true);
            } else {
                JsfUtil.addErrorMessage("CPF Invalido!");
                this.setCfpCnpjValidado(false);
                return (false);
            }
        } catch (InputMismatchException erro) {
            JsfUtil.addErrorMessage("CPF Invalido!");
            this.setCfpCnpjValidado(false);
            return (false);
        }
    }

    public Double bigDecimalToDouble(BigDecimal param) {
        if (param != null) {
            return param.doubleValue();
        } else {
            return 0.00;
        }
    }

    public Date somarDias(Date pDt, int dias) {
        int qtdeDias = dias * (24 * 60 * 60 * 1000);
        Calendar cal1 = new GregorianCalendar();
        cal1.setTime(pDt);
        cal1.setTimeInMillis(cal1.getTimeInMillis() + qtdeDias);
        return cal1.getTime();
    }

    public Double arredonda(Double param, int casas) {
        BigDecimal res = new BigDecimal(param).setScale(casas, RoundingMode.HALF_EVEN);
        String numeroFormatado = formatNumber(res.doubleValue(), "0." + rPad("", "0", casas));
        return Double.parseDouble(numeroFormatado);
    }

    private String gerarToken(String login, Integer expiraEmDias) {
        //Defini qual vai ser o algoritmo da assinatura no caso vai ser o HMAC SHA512
        SignatureAlgorithm algoritimoAssinatura = SignatureAlgorithm.HS512;

        //Data atual que data que o token foi gerado
        Date agora = new Date();

        //Define at� que data o token � pelo quantidade de dias que foi passo pelo par�metro expiraEmDias
        Calendar expira = Calendar.getInstance();

        expira.add(Calendar.DAY_OF_MONTH, expiraEmDias);

        //Encoda a frase segredo pra base64 pra ser usada na gera��o do token 
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("SENHA CABALISTICA");

        SecretKeySpec key = new SecretKeySpec(apiKeySecretBytes, algoritimoAssinatura.getJcaName());

        //E finalmente utiliza o JWT builder pra gerar o token
        JwtBuilder construtor = Jwts.builder()
                .setIssuedAt(agora)//Data que o token foi gerado
                .setIssuer(login)//Coloca o login do usu�rio mais podia qualquer outra informa��o
                .signWith(algoritimoAssinatura, key)//coloca o algoritmo de assinatura e frase segredo j� encodada
                .setExpiration(expira.getTime());// coloca at� que data que o token � valido

        return construtor.compact();//Constr�i o token retornando ele como uma String

    }

    public Claims validaToken(String token) {
        try {
            //JJWT vai validar o token caso o token n�o seja valido ele vai executar uma exeption
            //o JJWT usa a frase segredo pra descodificar o token e ficando assim possivel
            //recuperar as informa��es que colocamos no payload
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary("SENHA CABALISTICA"))
                    .parseClaimsJws(token).getBody();

            //Aqui � um exemplo que se o token for valido e descodificado 
            //vai imprimir o login que foi colocamos no token
            System.out.println(claims.getIssuer());
            return claims;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void mensagemDlg(String titulo, String msg) {
        msgTitulo = titulo;
        msgMensagem = msg;
        RequestContext.getCurrentInstance().update("MensagemForm:displayMsg");
    }

    public String getMsgTitulo() {
        return msgTitulo;
    }

    public void setMsgTitulo(String msgTitulo) {
        this.msgTitulo = msgTitulo;
    }

    public String getMsgMensagem() {
        return msgMensagem;
    }

    public void setMsgMensagem(String msgMensagem) {
        this.msgMensagem = msgMensagem;
    }

    public int getMsgBotao() {
        return msgBotao;
    }

    public void setMsgBotao(int msgBotao) {
        this.msgBotao = msgBotao;
    }

    public void msgResposta(int btnPressionado) {
        this.msgBotao = btnPressionado;
    }

    public String getMsgTipo() {
        return msgTipo;
    }

    public void setMsgTipo(String msgTipo) {
        this.msgTipo = msgTipo;
    }

    
    public void mensagem(String msg) {
        mensagem(msg, "", MensagemTipo.INFO);
    }

    public void mensagem(String msg, String titulo) {
        mensagem(msg, titulo, MensagemTipo.INFO);
    }

    public void mensagem(String msg, String titulo, MensagemTipo tpMsg) {
        setMsgMensagem(msg);
        setMsgTitulo(titulo);
        setMsgTipo("info");
        if (tpMsg.equals(MensagemTipo.SUCCESS)) {
            setMsgTipo("success");
        }
        if (tpMsg.equals(MensagemTipo.WARNING)) {
            setMsgTipo("warning");
        }
        if (tpMsg.equals(MensagemTipo.ERROR)) {
            setMsgTipo("error");
        }
        if (tpMsg.equals(MensagemTipo.INFO)) {
            setMsgTipo("info");
        }
        RequestContext.getCurrentInstance().update("mensagem-texto");
        RequestContext.getCurrentInstance().update("mensagem-titulo");
        RequestContext.getCurrentInstance().update("mensagem-tipo");
        //Roda o JavaScript para mostrar a mensagem
        //System.out.println("tit:"+msgTitulo+" txt:"+msg+" tp:"+msgTipo);
        RequestContext.getCurrentInstance().execute("mostramsg()");
    }

}
