using RSI_lista2;
using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.ServiceModel.Description;
using System.Text;
using System.Threading.Tasks;
using WcfServiceLibrary2;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
        //Krok 1, dla utrwalenia, Uri dla bazowego adresu serwisu
        Uri baseAddress = new Uri("http://localhost:8733/Design_Time_Addresses/RSI_lista2/Service1/mex");

        

            //Krok 2, do zapamiętania, Instancja serwisu
            ServiceHost myHost = new ServiceHost(typeof(MyCalculator), baseAddress);

            //Krok 3 Endpoint serwisu
            BasicHttpBinding myBinding = new BasicHttpBinding();
            ServiceEndpoint endpoint1 = myHost.AddServiceEndpoint(typeof(ICalculator), myBinding, "endpoint1");

            //Krok 4, Ustawianie metadanych
            ServiceMetadataBehavior smb = new ServiceMetadataBehavior();
            smb.HttpGetEnabled = true;
            myHost.Description.Behaviors.Add(smb);

            try
            {
                WSHttpBinding binding2 = new WSHttpBinding();
                binding2.Security.Mode = SecurityMode.None;
                ServiceEndpoint endpoint2 = myHost.AddServiceEndpoint(typeof(ICalculator), binding2, "endpoint2");

                Console.WriteLine("\n---> Endpoints:");
                Console.WriteLine("\nService endpoint {0}:", endpoint1.Name);
                Console.WriteLine("Binding: {0}", endpoint1.Binding.ToString());
                Console.WriteLine("ListenUri: {0}", endpoint1.ListenUri.ToString());
                Console.WriteLine("\nService endpoint {0}:", endpoint2.Name);
                Console.WriteLine("Binding: {0}", endpoint2.Binding.ToString());
                Console.WriteLine("ListenUri: {0}", endpoint2.ListenUri.ToString());
                Console.WriteLine("");
                //Krok 5, Uruchomienie serwisu
                myHost.Open();
                Console.WriteLine("Service is started and running");
                Console.WriteLine("Press <ENTER> to STOP service...");
                Console.WriteLine("");
                Console.ReadLine();
                myHost.Close();
            }
            catch(CommunicationException ce)
            {
                Console.WriteLine("Exception occured: {0}", ce.Message);
                myHost.Abort();
            }


            Uri baseAddress3 = new Uri("http://localhost:10007/Service2");
            ServiceHost myHost3 = new ServiceHost(typeof(MySuperCalc), baseAddress3);
            WSDualHttpBinding myBinding3 = new WSDualHttpBinding();
            ServiceEndpoint endpoint3 = myHost3.AddServiceEndpoint(typeof(ISuperCalc), myBinding3, "endpoint3");
            myHost3.Description.Behaviors.Add(smb);

            try
            {
                //WSHttpBinding binding2 = new WSHttpBinding();
                //binding2.Security.Mode = SecurityMode.None;
                //ServiceEndpoint endpoint2 = myHost.AddServiceEndpoint(typeof(ICalculator), binding2, "endpoint2");

                //Krok 5, Uruchomienie serwisu
                myHost3.Open();
                Console.WriteLine("Service is started and running");
                Console.WriteLine("Press <ENTER> to STOP service...");
                Console.WriteLine("");
                Console.ReadLine();
                myHost3.Close();
            }
            catch (CommunicationException ce)
            {
                Console.WriteLine("Exception occured: {0}", ce.Message);
                myHost.Abort();
            }
        }
    }
}
