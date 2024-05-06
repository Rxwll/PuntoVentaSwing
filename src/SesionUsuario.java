public class SesionUsuario {
    private static SesionUsuario instance=null;
    private String userID;
    private String userName;

    private SesionUsuario(String userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    public static synchronized void createInstance(String userID, String userName){
        if (instance == null) {
            instance = new SesionUsuario(userID, userName);
        }
    }

    public static SesionUsuario getInstance(){
        if (instance == null){
            throw new RuntimeException("No hay una sesión activa");
        }
        return instance;
    }
    public static void clearSession(){
        instance = null;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }
}
