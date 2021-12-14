/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikinfo.neoserp.aplicacao.facade;

import net.unikinfo.neoserp.aplicacao.model.Operacaoimposto;
import net.unikinfo.neoserp.aplicacao.model.Transacao;
import net.unikinfo.neoserp.aplicacao.model.Transacaoimposto;
import net.unikinfo.neoserp.aplicacao.model.Transacaoitem;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Carlos
 */
public class CalculaNotaFiscalFacade {
	@Autowired
    private TransacaoitemFacade ejbTransIt;
    @Autowired
    private TransacaoFacade ejbTrans;
    @Autowired
    TransacaoimpostoFacade ejbTrImposto;
    @Autowired
    private OperacaoimpostoFacade operacaoimpostoFacade;
    
    public void CalculaNotaFiscalFacade(){
        /* Implementar o Construtor */
        ejbTransIt   = new TransacaoitemFacade();
        ejbTrans     = new TransacaoFacade();
        ejbTrImposto = new TransacaoimpostoFacade();
    }
    
    public void calculaTotalItens(Transacao tr) {
        List<Transacaoitem> trLst;
        Transacao trans = new Transacao();
        trans = (Transacao) ejbTrans.find(tr.getIdTransacao());
        
        trLst = ejbTransIt.getTransacaoItensPorTransacao(trans);

        //trans =  ejbTrans.find(tr);
        //trLst = trans.getTransacaoitemList();
        
        Transacaoimposto trImp = new Transacaoimposto();
        
        for(Transacaoitem trIt: trLst){
            if ((trIt.getValorUnitarioItem()!= BigDecimal.ZERO) && (trIt.getQuantidadeItem() != BigDecimal.ZERO)) {
                trIt.setTotalItem( arredonda(trIt.getQuantidadeItem().multiply(trIt.getValorUnitarioItem()),2));
            } else {
                trIt.setTotalItem( BigDecimal.ZERO );
            }
            ejbTransIt.edit(trIt);
            for(Operacaoimposto operacaoImp : operacaoimpostoFacade.getOperacaoImpostoPorOperacao(tr.getOperacao()) ) {
              if( (!operacaoImp.getAliqOperacaoImposto().equals(BigDecimal.ZERO)) &&
                  (trIt.getTotalItem().doubleValue() >= operacaoImp.getTipoimposto().getCalcularImpostoAPartirDe().doubleValue())) {
                    trImp.setTransacao(tr);
                    trImp.setTipoimposto(operacaoImp.getTipoimposto());
                    trImp.setAliqImposto(operacaoImp.getAliqOperacaoImposto());
                    trImp.setBaseCalculoImposto(trIt.getTotalItem());
                    trImp.setValorImposto(trIt.getTotalItem().multiply(operacaoImp.getAliqOperacaoImposto()));
                    ejbTrImposto.edit(trImp);
              }
            }
            
        }
    }

    public BigDecimal arredonda(BigDecimal valor, int casas){
        BigDecimal arredondado = valor; 
        arredondado = arredondado.setScale(casas, BigDecimal.ROUND_HALF_UP); 
        return arredondado;
    }
    
    
}
