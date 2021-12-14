angularApp.config(function($routeProvider) {
    $routeProvider.when('/home', {
        templateUrl: '../partials/home.html',
        controller: 'controller'
    }).when('/historia', {
        templateUrl: '../partials/simple_page.html',
        controller: 'controller'
    }).when('/chegadas_partidas', {
        templateUrl: '../partials/chegadas_partidas.html',
        controller: 'controller'
    }).when('/sobre_o_vlt', {
        templateUrl: '../partials/categoria-menu.html',
        controller: 'controller'
    }).when('/nossa_rede', {
        templateUrl: '../partials/categoria-menu.html',
        controller: 'controller'
    }).when('/fale_conosco', {
        templateUrl: '../partials/categoria-menu.html',
        controller: 'controller'
    }).when('/institucional', {
        templateUrl: '../partials/simple_page.html',
        controller: 'controller'
    }).when('/perguntas_frequentes', {
        templateUrl: '../partials/perguntas_frequentes.html',
        controller: 'controller'
    }).when('/achados_perdidos', {
        templateUrl: '../partials/achados_perdidos.html',
        controller: 'controller'
    }).when('/galeria', {
        templateUrl: '../partials/galeria.html',
        controller: 'controller'
    }).when('/transparencia', {
        templateUrl: '../partials/transparencia.html',
        controller: 'controller'
    }).when('/responsabilidade_social', {
        templateUrl: '../partials/responsabilidade_social.html',
        controller: 'controller'
    }).when('/mapa_rede', {
        templateUrl: '../partials/mapa_rede.html',
        controller: 'controller'
    }).when('/mapa_turistico', {
        templateUrl: '../partials/mapa_turistico.html',
        controller: 'controller'
    }).when('/conexoes', {
        templateUrl: '../partials/conexoes.html',
        controller: 'controller'
    }).when('/noticias', {
        templateUrl: '../partials/noticias.html',
        controller: 'controller'
    }).when('/manual_usuario', {
        templateUrl: '../partials/manual_usuario.html',
        controller: 'controller'
    }).when('/sala_imprensa', {
        templateUrl: '../partials/sala_imprensa.html',
        controller: 'controller'
    }).when('/sala_imprensa', {
        templateUrl: '../partials/sala_imprensa.html',
        controller: 'controller'
    }).when('/ouvidoria', {
        templateUrl: '../partials/ouvidoria.html',
        controller: 'controller'
    }).when('/trabalhe_aqui', {
        templateUrl: '../partials/trabalhe_aqui.html',
        controller: 'controller'
    }).when('/canal_confidencial', {
        templateUrl: '../partials/canal_confidencial.html',
        controller: 'controller'
    }).when('/aplicativos', {
        templateUrl: '../partials/aplicativos.html',
        controller: 'controller'
    }).otherwise('/home');
});

angularApp.controller("controller", function($scope, $http, $timeout, $sce, $location, Upload, Notifications) {

    $scope.isLoading = false;
    $scope.textLanguage = 'pt';

    $scope.opcoes_data = [
        'Dia da Semana',
        'Fim de Semana',
        'Data Especial'
    ];

    $scope.opcao_data_escolhida = 'Dia da Semana';
    $scope.data_especial = null;

    $scope.$on('$routeUpdate', function(){
        $scope.textLanguage = 'pt';
    });

    var apiAddress = '';

    $scope.editorConfig = {
        sanitize: false,
        toolbar: [
            { name: 'basicStyling', items: ['bold', 'italic', 'underline'] },
            { name: 'styling', items: ['size'] },
        ]
    };

    $scope.editorApi = {
        scope: $scope
    };

    $timeout(function() {
        // esconde o footer do editor (nao eh possivel via configuracao)
       $(".tinyeditor-footer").hide();
    }, 100);

    $scope.filter = {
        title: ""
        , page: 1
        , pageSize: 10
    };

    $scope.asHtml = function(text) {
      return $sce.trustAsHtml(text);
    };

    var counterLoading = 0;

    // CARREGAR ITENS ESPECÍFICOS
    $scope.load = function(page) {
        if(!counterLoading) {
            Notifications.showLoading();
        }
        counterLoading++;

        $scope.filter.page = page;

        $http({
            url:  contextRoot + apiAddress + "/pesquisa",
            method: "POST",
            data: JSON.stringify($scope.filter),
            headers: {'Content-Type': 'application/json'}
        }).then(
            function (result) {

                counterLoading--;
                if(!counterLoading) {
                    Notifications.hideLoading();
                }

                var dataReceived = result.data;
                if(dataReceived.value) {
                    $scope.data = dataReceived.data;
                    if(currentAddress == "home") {
                        var availablePositions = [1,2,3,4,5,6,7,8,9];
                        for (var i = 0; i < availablePositions.length; i++) {

                            mosaicoNaoEncontrado = true;

                            for (var j in $scope.data.list) {
                                var entity = $scope.data.list[j];
                                if(entity.position == availablePositions[i]) {
                                    mosaicoNaoEncontrado = false;
                                    break;
                                }
                            }

                            if(mosaicoNaoEncontrado) {
                                $scope.data.list.push({
                                    position: availablePositions[i]
                                });
                            }
                        }
                    }
                } else {
                    Notifications.showErrorMessage(MESSAGE_FAILED_LOADING_DATA);
                }
            }
            , function() {

                counterLoading--;
                if(!counterLoading) {
                    Notifications.hideLoading();
                }

                Notifications.showErrorMessage(MESSAGE_FAILED_LOADING_DATA);
            }
        );
    };

    // ITENS ESPECÍFICOS DE CADA PÁGINA
    $scope.addClicked = function() {

        if(currentAddress === 'chegadas_partidas') {
            if(!$scope.data) {
                return;
            }

            var dateString = null;

            if($scope.data_especial instanceof Date) {
                dateString = $scope.data_especial.getDate() + '/' + ($scope.data_especial.getMonth() + 1) + '/' + $scope.data_especial.getFullYear();
            }

            var diaData = $scope.opcao_data_escolhida;

            if($scope.opcao_data_escolhida === 'Data Especial' && dateString == null) {
                return;
            }
            if($scope.opcao_data_escolhida === 'Data Especial') {
                diaData = dateString;
            }

            var hourObj = {};

            for (var i = 0; i < $scope.data.list.length; i++) {
                var obj = $scope.data.list[i];

                if(obj.dia === diaData) {
                    hourObj[obj.hora] = true;
                }
            }

            for (var i = 0; i < 24; i++) {
                if(!hourObj[i]) {
                    $scope.data.list.push({dia: diaData,hora:i});
                }
            }
        } else {
            $scope.editingEntity = {
                image: {}, source: {
                    id: "BACKOFFICE",
                    displayName: "Backoffice"
                }
            };

            $scope.crudForm.$setPristine();
            $scope.crudForm.$setUntouched();
            $('#crudModal').modal('show');
        }
    };

    $scope.editClicked = function(entity) {
        Notifications.showLoading();

        if(entity.id) {
            $http({
                url:  contextRoot + apiAddress
                , method: "GET"
                , params: {id: entity.id }
                , headers: {'Content-Type': 'application/json'}
            }).then(
                function (result, status, headers, config) {
                    Notifications.hideLoading(function() {
                        var dataReceived = result.data;
                        if(dataReceived.value) {
                            $scope.editingEntity = dataReceived.data;
                            $scope.editingEntity.source = entity;
                            if($scope.editingEntity.active) {
                                $scope.editingEntity.active = $scope.editingEntity.active.toString();
                            }
                            $scope.crudForm.$setPristine();
                            $scope.crudForm.$setUntouched();
                            $('#crudModal').modal('show');
                        } else {
                            Notifications.showErrorMessage(MESSAGE_FAILED_LOADING_DATA);
                        }
                    });
                }
                , function() {
                    Notifications.hideLoading(function() {
                        Notifications.showErrorMessage(MESSAGE_FAILED_LOADING_DATA);
                    });
                }
            );
        } else if (currentAddress == 'home' || currentAddress == 'chegadas_partidas') {
            $scope.editingEntity = entity;
            $scope.textLanguage = "pt";
            $('#crudModal').modal('show');
            Notifications.hideLoading(function(){});
        }
    };

    $scope.triedToSubmit = false;

    $scope.confirmUpsertClicked = function() {

        // Mosaico
        if(currentAddress == 'home') {
            if(!$scope.editingEntity['image'].filename) {
                Notifications.showErrorMessage("Imagem obrigatória no Mosaico. Insira a imagem e tente novamente.");
                return;
            }
        }

        var textOk = true;

        if(hasText) {

            textOk = $scope.editingEntity.textPor !== '' &&
                $scope.editingEntity.textPor !== null &&
                $scope.editingEntity.textPor !== undefined &&
                $scope.editingEntity.textEng !== '' &&
                $scope.editingEntity.textEng !== null &&
                $scope.editingEntity.textEng !== undefined &&
                $scope.editingEntity.textEsp !== '' &&
                $scope.editingEntity.textEsp !== null &&
                $scope.editingEntity.textEsp !== undefined;
        }

        if($scope.crudForm.$valid && textOk) {
            $scope.triedToSubmit = false;
            Notifications.showLoading();

            $http({
                url:  contextRoot + apiAddress
                , method: "POST"
                , data: $scope.editingEntity
                , headers: {'Content-Type': 'application/json'}
            }).then(
                function (result, status, headers, config) {
                    Notifications.hideLoading(function() {
                        var response = result.data;
                        if(response.success) {
                            $('#crudModal').modal('hide');

                            if($scope.editingEntity.source) {
                                $.extend($scope.editingEntity.source, $scope.editingEntity);
                                Notifications.showSuccessMessage(MESSAGE_CRUD_UPDATE_SUCCESS);
                                $scope.load($scope.filter.page);
                            } else {
                                $scope.load($scope.filter.page);
                                Notifications.showSuccessMessage(MESSAGE_CRUD_INSERT_SUCCESS);
                            }
                        } else {
                            Notifications.renderBusinessErrorBundle(response, $scope.crudForm);
                        }
                    });
                }
                , function() {
                    Notifications.hideLoading(function() {
                        Notifications.showErrorMessage(MESSAGE_FAILED_OPERATION);
                    });
                }
            );
        } else {
            $scope.triedToSubmit = true;
            Notifications.showErrorMessage("Verifique os campos que ainda não foram preenchidos.");
        }
    };

    $scope.cancelUpsertClicked = function() {
        $('#crudModal').modal('hide');
    };

    $scope.removeClicked = function(entity) {
        var doRemove = function() {
            Notifications.showLoading();
            $http({
                url: contextRoot + apiAddress
                , data: {id: entity.id}
                , method: "DELETE"
                , headers: {'Content-Type': 'application/json'}
            }).then(
                function (result, status, headers, config) {
                    Notifications.hideLoading(function() {
                        var response = result.data;
                        if(response.success) {
                            $scope.load($scope.filter.page);
                            Notifications.showSuccessMessage(MESSAGE_CRUD_DELETE_SUCCESS);
                        } else {
                            Notifications.renderBusinessErrorBundle(response);
                        }
                    });
                }
                , function() {
                    Notifications.hideLoading(function() {
                        Notifications.showErrorMessage(MESSAGE_FAILED_OPERATION);
                    });
                }
            )
        };

        Notifications.showConfirmMessage("Tem certeza de que deseja remover este cadastro?", doRemove);
    };

    // UPLOAD E DOWNLOAD DE ARQUIVOS
    $scope.uploadFileToServer = function(imageEntity, file) {

        if(!file) {
            return;
        }

        var url = contextRoot + 'configuracoes/' + imageEntity + '/upload';

        if(imageEntity == 'image' || imageEntity == 'imageNoite') {
            url = contextRoot + 'pagina_website/upload';
        } else if(imageEntity == 'image_galeria') {
            url = contextRoot + 'item-galeria/upload';
        } else if(imageEntity == 'image_foto_lateral') {
            url = contextRoot + 'foto-responsabilidade-social/upload';
        } else if(imageEntity == 'image-conexoes') {
            url = contextRoot + 'conexao/upload';
        } else if(imageEntity == 'demonstrativo') {
            url = contextRoot + 'demonstrativo_financeiro/upload';
        } else if(imageEntity == 'image_noticia_site') {
            url = contextRoot + 'noticia_site/upload';
        } else if(imageEntity == 'image_mosaico' || imageEntity == 'image_noite_mosaico') {
            url = contextRoot + 'mosaico/upload';
        }

        Notifications.showLoading();
        file.upload = Upload.upload({
            url: url,
            data: { type: imageEntity, file: file }
        });

        file.upload.then(
            function (response) {

                console.log(response);

                var dataReceived = response.data;
                Notifications.hideLoading(function() {

                    if(!dataReceived.value) {

                        var errorMsg = "";
                        for (var prop in dataReceived.data) {
                            if(dataReceived.data.hasOwnProperty(prop)) {
                                errorMsg = errorMsg + dataReceived.data[prop] + "; ";
                            }
                        }

                        Notifications.showErrorMessage(errorMsg);

                    } else {
                        if(dataReceived.value) {
                            if(imageEntity == "manual-usuario") {
                                $scope.config['manualUsuario'] = dataReceived.data;
                            } else if (imageEntity == "mapa-rede") {
                                $scope.config['mapaRede'] = dataReceived.data;
                            } else if (imageEntity == "image_galeria" || imageEntity == "image-conexoes" ||
                                imageEntity == "image_foto_lateral") {
                                $scope.editingEntity['image'] = dataReceived.data;
                            } else if (imageEntity == "mapa-turistico") {
                                $scope.config['mapaTuristico'] = dataReceived.data;
                            } else if (imageEntity == "demonstrativo" || imageEntity == "image_noticia_site") {
                                $scope.editingEntity['image'] = dataReceived.data;
                            } else if (imageEntity == 'image' || imageEntity == 'imageNoite') {
                                $scope.actualPage[imageEntity] = dataReceived.data;
                            } else if (imageEntity == 'image_mosaico') {
                                $scope.editingEntity['image'] = dataReceived.data;
                            } else if (imageEntity == 'image_noite_mosaico') {
                                $scope.editingEntity['imageNoite'] = dataReceived.data;
                            }
                        } else {
                            $.each(dataReceived.data, function(key, value) {
                                $scope.crudForm[imageEntity].$setValidity(key, false);
                                $scope.crudForm[imageEntity].$error[key] = value;
                            });
                        }

                    }
                });
            }
            , function (response) {
                if (response.status > 0) {
                    Notifications.showErrorMessage(MESSAGE_FAILED_OPERATION);
                }
            }
        );
    };

    $scope.cancelUploadedFile = function(imageEntity) {
        if(imageEntity == 'manual-usuario') {
            delete $scope.config.manualUsuario.id;
            delete $scope.config.manualUsuario.filename;
            saveConfig();
        } else if (imageEntity == "mapa-rede") {
            delete $scope.config.mapaRede.id;
            delete $scope.config.mapaRede.filename;
            saveConfig();
        } else if (imageEntity == "demonstrativo" || imageEntity == "image_noticia_site") {
            delete $scope.editingEntity['image'].id;
            delete $scope.editingEntity['image'].filename;
        } else if (imageEntity == "mapa-turistico") {
            delete $scope.config.mapaTuristico.id;
            delete $scope.config.mapaTuristico.filename;
            saveConfig();
        } else if (imageEntity == "image_galeria" || imageEntity == "image_conexoes" || imageEntity == "image_noticia_site") {
            delete $scope.editingEntity.image.id;
            delete $scope.editingEntity.image.filename;
            saveConfig();
        } else if (imageEntity == 'image' || imageEntity == 'imageNoite') {
            delete $scope.actualPage[imageEntity].id;
            delete $scope.actualPage[imageEntity].filename;
            saveConfig();
        } else if (imageEntity == 'image_mosaico' ) {
            delete $scope.editingEntity['image'].id;
            delete $scope.editingEntity['image'].filename;
        } else if (imageEntity == 'image_noite_mosaico') {
            delete $scope.editingEntity['imageNoite'].id;
            delete $scope.editingEntity['imageNoite'].filename;
        }
    };

    $scope.downloadFileClicked = function(fileEntity) {
        if(fileEntity == 'image' || fileEntity == 'imageNoite') {
            var refId = $scope.actualPage[fileEntity].id ? $scope.actualPage[fileEntity].id : $scope.actualPage.id;
            window.open(contextRoot + 'pagina_website/download?id=' +refId +'&filename=' +$scope.actualPage[fileEntity].filename, '_blank');
        } else if (fileEntity == 'demonstrativo') {
            var refId = $scope.editingEntity['image'].id ? $scope.editingEntity['image'].id : $scope.editingEntity.id;
            window.open(contextRoot + 'demonstrativo_financeiro/download?id=' +refId +'&filename=' +$scope.editingEntity['image'].filename, '_blank');
        } else if (fileEntity == 'image_noticia_site') {
            var refId = $scope.editingEntity['image'].id ? $scope.editingEntity['image'].id : $scope.editingEntity.id;
            window.open(contextRoot + 'noticia_site/download?id=' +refId +'&filename=' +$scope.editingEntity['image'].filename, '_blank');
        } else if (fileEntity == 'image_galeria') {
            var refId = $scope.editingEntity['image'].id ? $scope.editingEntity['image'].id : $scope.editingEntity.id;
            window.open(contextRoot + 'item-galeria/download?id=' +refId +'&filename=' +$scope.editingEntity['image'].filename, '_blank');
        } else if (fileEntity == 'image_foto_lateral') {
            var refId = $scope.editingEntity['image'].id ? $scope.editingEntity['image'].id : $scope.editingEntity.id;
            window.open(contextRoot + 'foto-responsabilidade-social/download?id=' +refId +'&filename=' +$scope.editingEntity['image'].filename, '_blank');
        } else if (fileEntity == 'image-conexoes') {
            var refId = $scope.editingEntity['image'].id ? $scope.editingEntity['image'].id : $scope.editingEntity.id;
            window.open(contextRoot + 'conexao/download?id=' +refId +'&filename=' +$scope.editingEntity['image'].filename, '_blank');
        } else if (fileEntity == 'image_mosaico' || fileEntity == 'image_noite_mosaico') {
            var imageEntity = 'image';
            if(fileEntity == 'image_noite_mosaico') {
                imageEntity = 'imageNoite';
            }
            var refId = $scope.editingEntity[imageEntity].id ? $scope.editingEntity[imageEntity].id : $scope.editingEntity.id;
            window.open(contextRoot + 'mosaico/download?id=' +refId +'&filename=' +$scope.editingEntity[imageEntity].filename, '_blank');
        } else {
            window.open(contextRoot + 'configuracoes/' + fileEntity + '/download', '_blank');
        }
    };

    // CONFIGURAÇÕES GERAIS
    var loadConfig = function(cb) {

        if(!counterLoading) {
            Notifications.showLoading();
        }
        counterLoading++;

        $http({
            url:  contextRoot + "configuracoes"
            , method: "GET"
            , headers: {'Content-Type': 'application/json'}
        }).then(
            function (result, status, headers, config) {

                counterLoading--;
                if(!counterLoading) {
                    Notifications.hideLoading();
                }

                var dataReceived = result.data;
                if(dataReceived.value) {
                    $scope.config = dataReceived.data;
                    $scope.config.recargaFacil = $scope.config.recargaFacil.id;
                    $scope.config.maxNoticiasPublicadas = $scope.config.maxNoticiasPublicadas.toString();
                    $scope.config.amanhecerInput = new Date(1970,01,01,Math.floor($scope.config.amanhecer/60),$scope.config.amanhecer%60,0,0);
                    $scope.config.anoitecerInput = new Date(1970,01,01,Math.floor($scope.config.anoitecer/60),$scope.config.anoitecer%60,0,0);
                } else {
                    Notifications.showErrorMessage("Ocorreu uma falha inesperada ao carregar as configurações do servidor.");
                }
            }, function() {
                counterLoading--;
                if(!counterLoading) {
                    Notifications.hideLoading();
                }

                Notifications.showErrorMessage("Ocorreu uma falha inesperada ao carregar as configurações do servidor.");
            }
        );
    };

    var saveConfig = function() {

        var amI = $scope.config.amanhecerInput;
        var anI = $scope.config.anoitecerInput;
        $scope.config.amanhecer = amI.getHours()*60 + amI.getMinutes();
        $scope.config.anoitecer = anI.getHours()*60 + anI.getMinutes();

        Notifications.showLoading();
        $http({
            url:  contextRoot + "configuracoes"
            , method: "POST"
            , data: $scope.config
            , headers: {'Content-Type': 'application/json'}
        }).then(
            function (result, status, headers, config) {
                Notifications.hideLoading(function() {
                    var dataReceived = result.data;
                    if(dataReceived.value) {
                        Notifications.showSuccessMessage('Configurações alteradas com sucesso.', 'success');
                    } else {
                        Notifications.showErrorMessage("Ocorreu uma falha inesperada ao alterar as configurações.");
                    }
                });
            }, function() {
                Notifications.hideLoading(function() {
                    Notifications.showErrorMessage("Ocorreu uma falha inesperada ao alterar as configurações.");
                });
            }
        );
    };

    // CONFIGURAÇÕES PÁGINA WEBSITE
    var loadWebsitePage = function() {

        if(!counterLoading) {
            Notifications.showLoading();
        }
        counterLoading++;

        $scope.actualPage = {
            pagina:currentPage,
            textPor:"",
            textEng:"",
            textEsp:"",
            titlePor:"",
            titleEng:"",
            titleEsp:""
        };

        $http({
            url:  contextRoot + "pagina_website/pesquisa",
            method: "POST",
            data: JSON.stringify({}),
            headers: {'Content-Type': 'application/json'}
        }).then(
            function (result, status, headers, config) {
                var dataReceived = result.data;

                if(dataReceived.value) {
                    var paginasWebsite = dataReceived.data.list;

                    var actualPage = paginasWebsite[0];
                    var pageFound = false;

                    for (var i = 0; i < paginasWebsite.length; i++) {

                        actualPage = paginasWebsite[i];

                        if(actualPage.pagina == currentPage) {
                            pageFound = true;
                            $scope.actualPage = actualPage;
                            break;
                        }
                    }

                    if(pageFound) {
                        $http({
                            url:  contextRoot + "pagina_website"
                            , method: "GET"
                            , params: {id: $scope.actualPage.id }
                            , headers: {'Content-Type': 'application/json'}
                        }).then(
                            function (result, status, headers, config) {
                                counterLoading--;
                                if(!counterLoading) {
                                    Notifications.hideLoading();
                                }

                                var dataReceived = result.data;
                                if(dataReceived.value) {
                                    $scope.actualPage = dataReceived.data;
                                    $scope.originalActualPage = dataReceived.data;
                                } else {
                                    Notifications.showErrorMessage(MESSAGE_FAILED_LOADING_DATA);
                                }
                            }
                            , function() {
                                counterLoading--;
                                if(!counterLoading) {
                                    Notifications.hideLoading();
                                }

                                Notifications.showErrorMessage(MESSAGE_FAILED_LOADING_DATA);
                            }
                        );
                    } else {
                        counterLoading--;
                        if(!counterLoading) {
                            Notifications.hideLoading();
                        }
                    }
                } else {
                    counterLoading--;
                    if(!counterLoading) {
                        Notifications.hideLoading();
                    }

                    Notifications.showErrorMessage(MESSAGE_FAILED_LOADING_DATA);
                }
            }
            , function() {
                counterLoading--;
                if(!counterLoading) {
                    Notifications.hideLoading();
                }

                Notifications.showErrorMessage(MESSAGE_FAILED_LOADING_DATA);
            }
        );
    };

    $scope.saveWebsitePage = function() {
        Notifications.showLoading();
        $http({
            url:  contextRoot + "pagina_website"
            , method: "POST"
            , data: $scope.actualPage
            , headers: {'Content-Type': 'application/json'}
        }).then(
            function (result, status, headers, config) {
                Notifications.hideLoading(function() {
                    var response = result.data;
                    if(response.success) {
                        Notifications.showSuccessMessage(MESSAGE_CRUD_UPDATE_SUCCESS);
                        saveConfig();
                    } else {
                        Notifications.renderBusinessErrorBundle(response, $scope.crudForm);
                    }
                });
            }
            , function() {
                Notifications.hideLoading(function() {
                    Notifications.showErrorMessage(MESSAGE_FAILED_OPERATION);
                });
            }
        );
    };

    var addressParts = $location.path().split('/');

    var currentAddress = addressParts[addressParts.length - 1];
    var currentPage = "Home";
    var hasText = false;

    switch(currentAddress) {
        case "aplicativos":
            currentPage = "Aplicativo VLT";
            break;
        case "chegadas_partidas":
            apiAddress = "tempo_espera";
            $scope.load(1);
            currentPage = "Chegadas e Partidas";
            break;
        case "sobre_o_vlt":
            currentPage = "Sobre o VLT";
            break;
        case "nossa_rede":
            currentPage = "Nossa Rede";
            break;
        case "fale_conosco":
            currentPage = "Fale Conosco";
            break;
        case "achados_perdidos":
            currentPage = "Achados e Perdidos";
            break;
        case "canal_confidencial":
            currentPage = "Canal Confidencial";
            break;
        case "conexoes":
            apiAddress = 'conexao';
            $scope.load(1);
            hasText = true;
            currentPage = "Conexões";
            break;
        case "galeria":
            apiAddress = 'item-galeria';
            $scope.load(1);
            currentPage = "Galeria de Fotos";
            break;
        case "historia":
            currentPage = "Historia";
             break;
        case "home":
            apiAddress = 'mosaico';
            $scope.load(1);
            currentPage = "Home";
            break;
        case "institucional":
            currentPage = "Institucional";
            break;
        case "manual_usuario":
            apiAddress = 'item-manual';
            $scope.load(1);
            currentPage = "Manual do Usuário";
            break;
        case "mapa_rede":
            currentPage = "Mapa da Rede";
            break;
        case "mapa_turistico":
            currentPage = "Mapa Turístico";
            break;
        case "noticias":
            apiAddress = 'noticia_site';
            $scope.load(1);
            hasText = true;
            currentPage = "Notícias";
            break;
        case "ouvidoria":
            currentPage = "Ouvidoria";
            break;
        case "perguntas_frequentes":
            apiAddress = 'pergunta-frequente';
            $scope.load(1);
            currentPage = "Perguntas Frequentes";
            break;
        case "responsabilidade_social":
            apiAddress = 'foto-responsabilidade-social';
            $scope.load(1);
            currentPage = "Responsabilidade Social";
            break;
        case "sala_imprensa":
            currentPage = "Sala de Imprensa";
            break;
        case "trabalhe_aqui":
            apiAddress = 'vaga';
            $scope.load(1);
            currentPage = "Trabalhe Aqui";
            break;
        case "transparencia":
            apiAddress = 'demonstrativo_financeiro';
            $scope.load(1);
            currentPage = "Transparência";
            break;
        default:
            currentPage = "Home";
            break;
    }

    loadConfig();
    loadWebsitePage();

    // CARREGA ESTAÇÕES
    $http({
        url:  contextRoot + "estacoes/pesquisa",
        method: "POST",
        data: JSON.stringify({
            title: ""
            , page: 1
            , pageSize: 200
        }),
        headers: {'Content-Type': 'application/json'}
    }).then(function (result) {
        if(result.data.value) {
            $scope.estacoes = result.data.data.list;
        }
    });

});

angularApp.filter('customDateFilter', function() {
    return function(input,opcao_data_escolhida,data_especial) {

        var dateString = null;

        if(data_especial instanceof Date) {
            dateString = data_especial.getDate() + '/' + (data_especial.getMonth() + 1) + '/' + data_especial.getFullYear();
        }

        var output = [];

        if(!opcao_data_escolhida) return output;

        for (var i = 0; i < input.length; i++) {

            var inputObj = input[i];

            if(inputObj.dia === opcao_data_escolhida) output.push(inputObj);

            if(dateString && opcao_data_escolhida === 'Data Especial' && inputObj.dia === dateString) {
                output.push(inputObj);
            }
        }

        return output;
    };
})