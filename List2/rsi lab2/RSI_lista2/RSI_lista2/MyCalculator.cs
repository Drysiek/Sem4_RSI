using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace RSI_lista2
{
    // UWAGA: możesz użyć polecenia „Zmień nazwę” w menu „Refaktoryzuj”, aby zmienić nazwę klasy „Service1” w kodzie i pliku konfiguracji.
    
    [ServiceBehavior(InstanceContextMode = InstanceContextMode.Single, ConcurrencyMode = ConcurrencyMode.Multiple)]
    public class MyCalculator : ICalculator
    {
        public double Add(double val1, double val2)
        {
            double result = val1 + val2;
            Console.WriteLine("Wywołanie funkcji Add");
            return result;
        }
        public double Multiply(double val1, double val2)
        {
            double result = val1 * val2;
            Console.WriteLine("Wywołanie funkcji Multiply");
            return result;
        }
        public double HMultiply(double val1, double val2)
        {
            Console.WriteLine("Wywołanie funkcji HMultiply");
            System.Threading.Thread.Sleep(3000);
            double result = val1 * val2;
            Console.WriteLine("Wywołano funkcję HMultiply");
            return result;
        }
    }
}
