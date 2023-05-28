using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WcfServiceLibrary2
{
    //[ServiceBehavior(InstanceContextMode = InstanceContextMode.PerSession, ConcurrencyMode = ConcurrencyMode.Multiple)]
    [ServiceBehavior(InstanceContextMode = InstanceContextMode.Single, ConcurrencyMode = ConcurrencyMode.Multiple)]
    public class MySuperCalc : ISuperCalc
    {
        double result;
        ISuperCalcCallback callback = null;
        public MySuperCalc()
        {
            callback = OperationContext.Current.GetCallbackChannel
            <ISuperCalcCallback>();
        }

        public void DoSomething(int sec)
        {
            throw new NotImplementedException();
        }

        public void Factorial(double n)
        {
            Console.WriteLine("...called Factorial({0})", n);
            System.Threading.Thread.Sleep(1000);

            result = 1;
            for (int i = 1; i <= n; i++)
                result *= i;
            callback.FactorialResult(result);
        }
    }

}
