package Entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class Dossier implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    private int dosPgi;
    private String dosNom = new String();
    private String dosPeriodicite= new String();
    private String dosFormeJuridique= new String();
    private String dosRegimeImpo= new String();
    private int dosSiret=0;
    private int dosEffectif=0;
    private String dosNafId= new String();
    private String dosTypeMission= new String();
    private String dosAdresse= new String();
    private String dosCP= new String();
    private String dosVille= new String();
    private String dosPays= new String();
    private String dosEtat= new String();
    private String dosMoisCloture= new String();
    private String dosLangue= new String();
    private String dosCommentaire= new String();
    private String dosRegleFiscale= new String();
    private String dosImposition= new String();
    private String dosExigibilite= new String();
    private String dosBureau= new String();
    private String dosTVACabinet= new String(); //ATTENTION CHANGEMENT TYPE
    private String dosDateDepot = new String();
    private String dosRegleCompta= new String();
    private String dosUsrCegidId= new String();
    private String dosFiscaComment = new String();
/*    private ArrayList<Obligation> liste_obligation = new ArrayList<Obligation>();

	private HashMap<Integer,Obligation> map_obligation = new HashMap<Integer,Obligation>();
	private HashMap<Integer,HashMap<Integer,Obligation>> theme_map = new HashMap<Integer,HashMap<Integer,Obligation>>();

	public HashMap<Integer,HashMap<Integer,Obligation>> getTheme_map() {
		return theme_map;
	}

	public void setTheme_map(HashMap<Integer,HashMap<Integer,Obligation>> theme_map) {
		this.theme_map = theme_map;
	}
    
  	public HashMap<Integer,Obligation> getMap_obligation() {
		return map_obligation;
	}
  	
	public void setMap_obligation(HashMap<Integer,Obligation> map_obligation) {
		this.map_obligation = map_obligation;
	}
    
  	public ArrayList<Obligation> getListe_obligation() {
  		return liste_obligation;
  	}
  	public void setListe_obligation(ArrayList<Obligation> liste_obligation) {
  		this.liste_obligation = liste_obligation;
  	}

  	
    */
	public String getDosDateDepot() {
		return dosDateDepot;
	}
	public void setDosDateDepot(String dosDateDepot) {
		this.dosDateDepot = dosDateDepot;
	}
	public void setDosUsrCegidId(String dosUsrCegidId) {
		this.dosUsrCegidId = dosUsrCegidId;
	}
	public String getDosUsrCegidId() {
		return dosUsrCegidId;
	}
	public void setDosUsrCegid_ID(String dosUsrCegidId) {
		this.dosUsrCegidId = dosUsrCegidId;
	}
	public String getDosNom() {
		return dosNom;
	}
	public void setDosNom(String dosNom) {
		this.dosNom = dosNom;
	}
	public int getDosPgi() {
		return dosPgi;
	}
	public void setDosPgi(int dosPgi) {
		this.dosPgi = dosPgi;
	}
	public String getDosPeriodicite() {
		return dosPeriodicite;
	}
	public void setDosPeriodicite(String dosPeriodicite) {
		this.dosPeriodicite = dosPeriodicite;
	}
	public String getDosFormeJuridique() {
		return dosFormeJuridique;
	}
	public void setDosFormeJuridique(String dosFormeJuridique) {
		this.dosFormeJuridique = dosFormeJuridique;
	}
	public String getDosRegimeImpo() {
		return dosRegimeImpo;
	}
	public void setDosRegimeImpo(String dosRegimeImpo) {
		this.dosRegimeImpo = dosRegimeImpo;
	}
	public int getDosSiret() {
		return dosSiret;
	}
	public void setDosSiret(int dosSiret) {
		this.dosSiret = dosSiret;
	}
	public int getDosEffectif() {
		return dosEffectif;
	}
	public void setDosEffectif(int dosEffectif) {
		this.dosEffectif = dosEffectif;
	}
	public String getDosNafId() {
		return dosNafId;
	}
	public void setDosNafId(String dosNafId) {
		this.dosNafId = dosNafId;
	}
	public String getDosTypeMission() {
		return dosTypeMission;
	}
	public void setDosTypeMission(String dosTypeMission) {
		this.dosTypeMission = dosTypeMission;
	}
	public String getDosAdresse() {
		return dosAdresse;
	}
	public void setDosAdresse(String dosAdresse) {
		this.dosAdresse = dosAdresse;
	}
	public String getDosCP() {
		return dosCP;
	}
	public void setDosCP(String dosCP) {
		this.dosCP = dosCP;
	}
	public String getDosVille() {
		return dosVille;
	}
	public void setDosVille(String dosVille) {
		this.dosVille = dosVille;
	}
	public String getDosPays() {
		return dosPays;
	}
	public void setDosPays(String dosPays) {
		this.dosPays = dosPays;
	}
	public String getDosEtat() {
		return dosEtat;
	}
	public void setDosEtat(String dosEtat) {
		this.dosEtat = dosEtat;
	}
	public String getDosMoisCloture() {
		return dosMoisCloture;
	}
	public void setDosMoisCloture(String dosMoisCloture) {
		this.dosMoisCloture = dosMoisCloture;
	}
	public String getDosLangue() {
		return dosLangue;
	}
	public void setDosLangue(String dosLangue) {
		this.dosLangue = dosLangue;
	}
	public String getDosCommentaire() {
		return dosCommentaire;
	}
	public void setDosCommentaire(String dosCommentaire) {
		this.dosCommentaire = dosCommentaire;
	}
	public String getDosRegleFiscale() {
		return dosRegleFiscale;
	}
	public void setDosRegleFiscale(String dosRegleFiscale) {
		this.dosRegleFiscale = dosRegleFiscale;
	}
	public String getDosImposition() {
		return dosImposition;
	}
	public void setDosImposition(String dosImposition) {
		this.dosImposition = dosImposition;
	}
	public String getDosExigibilite() {
		return dosExigibilite;
	}
	public void setDosExigibilite(String dosExigibilite) {
		this.dosExigibilite = dosExigibilite;
	}
	public String getDosBureau() {
		return dosBureau;
	}
	public void setDosBureau(String dosBureau) {
		this.dosBureau = dosBureau;
	}
	public String getDosTVACabinet() {
		return dosTVACabinet;
	}
	public void setDosTVACabinet(String dosTVACabinet) {
		this.dosTVACabinet = dosTVACabinet;
	}

	public String getDosRegleCompta() {
		return dosRegleCompta;
	}
	public void setDosRegleCompta(String dosRegleCompta) {
		this.dosRegleCompta = dosRegleCompta;
	}
	public String getDosFiscaComment() {
		return dosFiscaComment;
	}
	public void setDosFiscaComment(String dosFiscaComment) {
		this.dosFiscaComment = dosFiscaComment;
	}
    
}
