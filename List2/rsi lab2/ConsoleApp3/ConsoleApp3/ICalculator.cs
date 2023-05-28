using System.ServiceModel;

namespace ConsoleApp3
{
    [ServiceContract(ProtectionLevel = System.Net.Security.ProtectionLevel.None)]
    public interface ICalculator
    {
        [OperationContract]
        double Add(double val1, double val2);
        [OperationContract]
        double Multiply(double val1, double val2);
        [OperationContract]
        double HMultiply(double val1, double val2);
    }
}
