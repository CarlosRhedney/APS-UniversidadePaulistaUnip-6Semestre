package MinisterioMeioAmbiente;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;

/**
 *@author Carlos Rhedney
 */
//Interface abstrata ICisBioxSDK estende StdCallLibrary.
//Somente implementação da Classe CisBioxSDK.
abstract interface ICisBioxSDK extends StdCallLibrary {

    ICisBioxSDK INSTANCE = (ICisBioxSDK) Native.loadLibrary("CIS_SDK", ICisBioxSDK.class);
    
    //Metodo publico que inicia o leitor biometrico.
    public int CIS_SDK_Biometrico_Iniciar();
    
    //Metodo publico que finaliza o leitor biometrico.
    public int CIS_SDK_Biometrico_Finalizar();

    //Metodo publico que lê a digital, template gerado.
    public int CIS_SDK_Biometrico_LerDigital(PointerByReference pTemplate);
    
    //Metodo publico que lê a digital template gerado, retorno.
    public Pointer CIS_SDK_Biometrico_LerDigital_RetornoPonteiro(IntByReference iRetorno);
    
    //Metodo publico que cancela a leitura da digital.
    public int CIS_SDK_Biometrico_CancelarLeitura();
    
    //Metodo publico que compara as digitais, templates gerados.
    public int CIS_SDK_Biometrico_CompararDigital(PointerByReference pAmostra1, PointerByReference pAmostra2);
    
    //Metodo publico que capturar a imagem da digital em WSQ
    public Pointer CIS_SDK_Biometrico_LerDigital_LerWSQ(IntByReference iRetorno, IntByReference iSize);
    
    //Metodo publico versão SDK.
    public Pointer CIS_SDK_Versao();

}
