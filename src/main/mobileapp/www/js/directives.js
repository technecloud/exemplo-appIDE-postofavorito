(function ($app) {

  
  /**
   * Em todo elemento que possuir o atibuto as-date será 
   * aplicado o componente Datetimepicker (http://eonasdan.github.io/bootstrap-datetimepicker/)
   * 
   * O componente se adequa de acordo com o formato, definido através do atributo format
   * espeficado no elemento.
   * Para data simples use format="DD/MMM/YYYY", para data e hora use format="DD/MM/YYYY HH:mm:ss"
   * 
   * @see http://eonasdan.github.io/bootstrap-datetimepicker/
   */

  
  app.directive('pwCheck', [function () { 'use strict';
    return {
      require: 'ngModel',
      link: function (scope, elem, attrs, ctrl) {
      var firstPassword = '#' + attrs.pwCheck;
      elem.add(firstPassword).on('keyup', function () {
        scope.$apply(function () {
        var v = elem.val()===$(firstPassword).val();
        ctrl.$setValidity('pwmatch', v);
        });
      });
      }
    }
  }])
  
  app.directive('timestampToDate', function() {
        return {
            require: 'ngModel',
            link: function(scope, ele, attr, ngModel) {
                // converts DOM value to ng-model
                Abastecimento.active.data.$parsers.push(function(value) {
                    return Date.parse(value);
                });

                // converts ng-model to DOM value
                Abastecimento.active.data.$formatters.push(function(value) {
                    var date = new Date(value);
                    return date;
                });
            }
        }
    });
  
  
  
  
  
} (app));