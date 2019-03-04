package Entites.referentiels.profilsConsommateur;

public class Profil {

	// R1
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

        public int getPurchaseVolume() { return purchaseVolume; }

        public void setPurchaseVolume(int purchaseVolume) { this.purchaseVolume = purchaseVolume; }

        private int profilT_id;
        private String profilT_name;
        private String product_Type;
        private int ageClient;
        private String sexClient;
        private int purchaseVolume;

        // R2
        
        private int numProfil;
        private String nomProfil,sexeClient,ageRange,purshaseFrequency,commandType;
		
        public int getNumProfil() {
			return numProfil;
		}

		public void setNumProfil(int numProfil) {
			this.numProfil = numProfil;
		}

		public String getNomProfil() {
			return nomProfil;
		}

		public void setNomProfil(String nomProfil) {
			this.nomProfil = nomProfil;
		}

		public String getSexeClient() {
			return sexeClient;
		}

		public void setSexeClient(String sexeClient) {
			this.sexeClient = sexeClient;
		}

		public String getAgeRange() {
			return ageRange;
		}

		public void setAgeRange(String ageRange) {
			this.ageRange = ageRange;
		}

		public String getPurshaseFrequency() {
			return purshaseFrequency;
		}

		public void setPurshaseFrequency(String purshaseFrequency) {
			this.purshaseFrequency = purshaseFrequency;
		}

		public String getCommandType() {
			return commandType;
		}

		public void setCommandType(String commandType) {
			this.commandType = commandType;
		}
        

}
