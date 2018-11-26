package Entites.referentiels.profilsConsommateur;

public class Profil {

        public int getProfilT_id() {
            return profilT_id;
        }

        public void setProfilT_id(int profilT_id) {
            this.profilT_id = profilT_id;
        }

        public String getProfilT_name() {
            return profilT_name;
        }

        public void setProfilT_name(String profilT_name) {
            this.profilT_name = profilT_name;
        }

        public String getProduct_Type() {
            return product_Type;
        }

        public void setProduct_Type(String product_Type) {
            this.product_Type = product_Type;
        }

        public int getAgeClient() {
            return ageClient;
        }

        public void setAgeClient(int ageClient) {
            this.ageClient = ageClient;
        }

        public String getSexClient() {
            return sexClient;
        }

        public void setSexClient(String sexClient) {
            this.sexClient = sexClient;
        }

        public int getVolumeAchat() {
            return volumeAchat;
        }

        public void setVolumeAchat(int volumeAchat) {
            this.volumeAchat = volumeAchat;
        }

        private int profilT_id;
        private String profilT_name;
        private String product_Type;
        private int ageClient;
        private String sexClient;
        private int volumeAchat;


        public Profil(int profilT_id, String profilT_name, String product_Type, int ageClient, String sexClient, int volumeAchat) {
            this.profilT_id = profilT_id;
            this.profilT_name = profilT_name;
            this.product_Type = product_Type;
            this.ageClient = ageClient;
            this.sexClient = sexClient;
            this.volumeAchat = volumeAchat;
        }

}
