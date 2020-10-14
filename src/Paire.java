import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Paire {

        private String valeur1, valeur2;

        public Paire(){
            this.valeur1 = null;
            this.valeur2 = null;
            System.out.println("Instanciation !");
        }

        public Paire(String val1, String val2){
            this.valeur1 = val1;
            this.valeur2 = val2;
            System.out.println("Instanciation avec des paramètres !");
        }

        public String toString(){
            return  "Je suis un objet qui a pour valeur : " + this.valeur1 +  " - " + this.valeur2;
        }

        public String getValeur1() {
            return valeur1;
        }

        public void setValeur1(String valeur1) {
            this.valeur1 = valeur1;
        }

        public String getValeur2() {
            return valeur2;
        }

        public void setValeur2(String valeur2) {
            this.valeur2 = valeur2;
        }
    public static void main(String[] args) {
        String nom = Paire.class.getName();
        try {
            //On crée un objet Class
            Class cl = Class.forName(nom);
            //Nouvelle instance de la classe Paire
            Object o = cl.newInstance();

            //On crée les paramètres du constructeur
            Class[] types = new Class[]{String.class, String.class};
            //On récupère le constructeur avec les deux paramètres
            Constructor ct = cl.getConstructor(types);

            //On instancie l'objet avec le constructeur surchargé !
            Object o2 = ct.newInstance(new String[]{"valeur 1 ", "valeur 2"} );

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
