using ConsoleApp3.ServiceReference1;
using ConsoleApp3.ServiceReference3;
using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ConsoleApp3
{

    class SuperCalcCallback: ISuperCalcCallback
    {
        public void FactorialResult(double result)
        {
            Console.WriteLine("Factorial = {0}", result);
        }
    }

    class Program
    {
        static async Task<double> callHMultiplyAsy(CalculatorClient myClient2, double n1, double n2)
        {
            Console.WriteLine("...called callHMultiplyAsync");
            double reply = await myClient2.HMultiplyAsync(n1, n2);
            Console.WriteLine("...finished callHMultiplyAsync");
            return reply;
        }
        static void Main(string[] args)
        {
            //-------------------------------------------------------------
            Console.WriteLine("The Client is started");

            Uri baseAddress;
            BasicHttpBinding myBinding = new BasicHttpBinding();
            baseAddress = new Uri("http://localhost:8733/Design_Time_Addresses/RSI_lista2/Service1/mex/endpoint1");
            EndpointAddress eAddress = new EndpointAddress(baseAddress);
            ChannelFactory<ICalculator> myCF = new ChannelFactory<ICalculator>(myBinding, eAddress);
            ICalculator myClient = myCF.CreateChannel();

            //-------------------------------------------------------------
            Console.WriteLine();
            Console.WriteLine("Calling for endpoint1:");

            Console.Write("...calling Add (for endpoint1) ");
            double result = myClient.Add(-3.7, 9.17);
            Console.WriteLine("Result = " + result);

            Console.Write("...calling Multiply (for endpoint1) ");
            result = myClient.Multiply(-3.7, 9.17);
            Console.WriteLine("Result = " + result);

            //-------------------------------------------------------------
            Console.WriteLine();
            Console.WriteLine("Calling for fendpoint2:");

            CalculatorClient myClient2 = new CalculatorClient("WSHttpBinding_ICalculator");
            Console.Write("...calling Multiply (for endpoint2) - ");
            result = myClient2.Multiply(1, 2);
            Console.WriteLine("Result = " + result);

            //-------------------------------------------------------------
            Console.WriteLine();
            Console.WriteLine("Calling Asynchronous:");

            Task<double> asyResult = callHMultiplyAsy(myClient2, 4, 6);
            System.Threading.Thread.Sleep(100);
            Task<double> asyResult2 = callHMultiplyAsy(myClient2, 6.9, 9.6);
            System.Threading.Thread.Sleep(100);
            Task<double> asyResult3 = callHMultiplyAsy(myClient2, 65.49, 19.06);

            Console.WriteLine();
            result = asyResult.Result;
            Console.WriteLine(result);
            result = asyResult2.Result;
            Console.WriteLine(result);
            result = asyResult3.Result;
            Console.WriteLine(result);

            //-------------------------------------------------------------
            Console.ReadLine();
            ((IClientChannel)myClient).Close();
            Console.WriteLine("Client closed- FINISHED");

            //-------------------------------------------------------------
            Console.WriteLine();
            Console.WriteLine("Change Host");
            Console.ReadLine();

            Console.WriteLine("The Client3 is started");
            SuperCalcCallback myCbHandler = new SuperCalcCallback();
            InstanceContext instanceContext = new InstanceContext(myCbHandler);
            SuperCalcClient myClient3 = new SuperCalcClient(instanceContext);

            //-------------------------------------------------------------
            Console.WriteLine();
            Console.WriteLine("Calling Factorial:");

            double value1 = 10;
            Console.WriteLine("...calling factorial({0})...", value1);
            myClient3.Factorial(value1);
            double value2 = 5;
            Console.WriteLine("...calling factorial({0})...", value2);
            myClient3.Factorial(value2);
            double value3 = 12;
            Console.WriteLine("...calling factorial({0})...", value3);
            myClient3.Factorial(value3);

            //-------------------------------------------------------------
            Console.ReadLine();
            myClient3.Close();
            Console.WriteLine("...Client3 closed- FINISHED");
            Console.ReadLine();
        }
    }
}
