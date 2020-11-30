package MinisterioMeioAmbiente;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

/**
 *@author Carlos Rhedney
 */
//Classe CisBioxSDK implementada pela Classe ICisBioxSDK,
//Verificação das DLL´s.
 class CisBioxSDK implements ICisBioxSDK {
     
    private static CisBioxSDK instance;

    private final ICisBioxSDK dll = ICisBioxSDK.INSTANCE;
    
    //Inicia o leitor biometrico.
    @Override
    public int CIS_SDK_Biometrico_Iniciar() {
        int iRetorno = dll.CIS_SDK_Biometrico_Iniciar();
        return iRetorno;
    }
    
    //Finaliza o leitor o leitor biometrico
    @Override
    public int CIS_SDK_Biometrico_Finalizar() {
        int iRetorno = dll.CIS_SDK_Biometrico_Finalizar();
        return iRetorno;
    }
    
    //Lê a digital, template.
    @Override
    public int CIS_SDK_Biometrico_LerDigital(PointerByReference pTemplate) {
        int iRetorno = dll.CIS_SDK_Biometrico_LerDigital(pTemplate);
        return iRetorno;
    }
    
    //Lê a digital, template gerado, retorno.
    @Override
    public Pointer CIS_SDK_Biometrico_LerDigital_RetornoPonteiro(IntByReference iRetorno) {
        Pointer pDigital;
        pDigital = dll.CIS_SDK_Biometrico_LerDigital_RetornoPonteiro(iRetorno);
        return pDigital;
    }
    
    //Cancela a leitura da biometria.
    @Override
    public int CIS_SDK_Biometrico_CancelarLeitura() {
        int iRetorno = dll.CIS_SDK_Biometrico_CancelarLeitura();
        return iRetorno;
    }
    
    //Compara as digitais, templates gerados.
    @Override
    public int CIS_SDK_Biometrico_CompararDigital(PointerByReference pAmostra1, PointerByReference pAmostra2) {
        int iRetorno = dll.CIS_SDK_Biometrico_CompararDigital(pAmostra1, pAmostra2);
        return iRetorno;
    }
    
    //Capturar a imagem da digital em WSQ.
    @Override
    public Pointer CIS_SDK_Biometrico_LerDigital_LerWSQ(IntByReference iRetorno, IntByReference iSize) {
        Pointer pImagem;
        pImagem = dll.CIS_SDK_Biometrico_LerDigital_LerWSQ(iRetorno, iSize);
        return pImagem;
    }
    
    //Versão SDK.
    @Override
    public Pointer CIS_SDK_Versao() {
        Pointer p;
        p = dll.CIS_SDK_Versao();
        return p;
    }
    
    //Instancia CisBioxSDk.
    public static synchronized CisBioxSDK getInstance(){
        
        if(instance == null){
            instance = new CisBioxSDK();
        }
        
        return instance;
    }

}
