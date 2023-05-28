﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Ten kod został wygenerowany przez narzędzie.
//     Wersja wykonawcza:4.0.30319.42000
//
//     Zmiany w tym pliku mogą spowodować nieprawidłowe zachowanie i zostaną utracone, jeśli
//     kod zostanie ponownie wygenerowany.
// </auto-generated>
//------------------------------------------------------------------------------

namespace ConsoleApp3.ServiceReference5 {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="ServiceReference5.ICalculator")]
    public interface ICalculator {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICalculator/Add", ReplyAction="http://tempuri.org/ICalculator/AddResponse")]
        double Add(double val1, double val2);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICalculator/Add", ReplyAction="http://tempuri.org/ICalculator/AddResponse")]
        System.Threading.Tasks.Task<double> AddAsync(double val1, double val2);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICalculator/Multiply", ReplyAction="http://tempuri.org/ICalculator/MultiplyResponse")]
        double Multiply(double val1, double val2);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICalculator/Multiply", ReplyAction="http://tempuri.org/ICalculator/MultiplyResponse")]
        System.Threading.Tasks.Task<double> MultiplyAsync(double val1, double val2);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICalculator/HMultiply", ReplyAction="http://tempuri.org/ICalculator/HMultiplyResponse")]
        double HMultiply(double val1, double val2);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/ICalculator/HMultiply", ReplyAction="http://tempuri.org/ICalculator/HMultiplyResponse")]
        System.Threading.Tasks.Task<double> HMultiplyAsync(double val1, double val2);
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface ICalculatorChannel : ConsoleApp3.ServiceReference5.ICalculator, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class CalculatorClient : System.ServiceModel.ClientBase<ConsoleApp3.ServiceReference5.ICalculator>, ConsoleApp3.ServiceReference5.ICalculator {
        
        public CalculatorClient() {
        }
        
        public CalculatorClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public CalculatorClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public CalculatorClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public CalculatorClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public double Add(double val1, double val2) {
            return base.Channel.Add(val1, val2);
        }
        
        public System.Threading.Tasks.Task<double> AddAsync(double val1, double val2) {
            return base.Channel.AddAsync(val1, val2);
        }
        
        public double Multiply(double val1, double val2) {
            return base.Channel.Multiply(val1, val2);
        }
        
        public System.Threading.Tasks.Task<double> MultiplyAsync(double val1, double val2) {
            return base.Channel.MultiplyAsync(val1, val2);
        }
        
        public double HMultiply(double val1, double val2) {
            return base.Channel.HMultiply(val1, val2);
        }
        
        public System.Threading.Tasks.Task<double> HMultiplyAsync(double val1, double val2) {
            return base.Channel.HMultiplyAsync(val1, val2);
        }
    }
}
