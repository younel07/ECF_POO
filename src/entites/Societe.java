package entites;

import java.util.regex.Pattern;

/**
 * La class societe contient tous les infos que les autres class vont heritées
 * @author Younes
 * @version 1.0
 * @since 27/02/2024
 *
 */

public abstract class Societe {

    private int idSociete;
    private String raisonSociale;
    private String numRue;
    private String nomRue;
    private String cdPostal;
    private String ville;
    private String telephone;
    private String mail;
    static private final Pattern REGRX_MAIL = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    private String commentaire;

    public Societe(int idSociete, String raisonSociale,
                   String numRue, String nomRue, String cdPostal, String ville,
                   String telephone, String mail, String commentaire) throws EntitiesException{
        setId(idSociete);
        setRaisonSociale(raisonSociale);
        setNumRue(numRue);
        setNomRue(nomRue);
        setCdPostal(cdPostal);
        setVille(ville);
        setTelephone(telephone);
        setMail(mail);
        setCommentaire(commentaire);
    }

    //constructeur pour le test
    public Societe() {
    }

    public void setId(int p_id) throws EntitiesException{
        if (p_id>0)
        {
            idSociete = p_id;
        }else throw new EntitiesException("Id doit etre superieur a zero");
    }
    public int getId() {
        return idSociete;
    }
    public void setRaisonSociale(String p_raisonSocial) throws EntitiesException {
        if (p_raisonSocial != null && !p_raisonSocial.isEmpty()){
        raisonSociale = p_raisonSocial;
        }else throw new EntitiesException("Champs obligatoir ");
    }
    public String getRaisonSociale() {
        return raisonSociale;
    }
    public void setNumRue(String p_numRue) throws EntitiesException{
        if (p_numRue != null && !p_numRue.isEmpty()){
            numRue = p_numRue;
        }else throw new EntitiesException("champ obligatoir ");
    }
    public String getNumRue() {
        return numRue;
    }
    public void setNomRue(String p_nomRue) throws EntitiesException {
        if (p_nomRue != null && !p_nomRue.isEmpty()){
            nomRue = p_nomRue;
        }else throw new EntitiesException("champ obligatoir ");;
    }
    public String getNomRue() {
        return nomRue;
    }
    public void setCdPostal(String p_cdPostal) throws EntitiesException {
        if (p_cdPostal != null && !p_cdPostal.isEmpty()){
            cdPostal = p_cdPostal;
        }else throw new EntitiesException("champ obligatoir ");
    }
    public String getCdPostal() {
        return cdPostal;
    }
    public void setVille(String p_ville) throws EntitiesException {
        if (p_ville != null && !p_ville.isEmpty()){
            ville = p_ville;
        }else throw new EntitiesException("champ obligatoir ");
    }
    public String getVille() {
        return ville;
    }
    public void setTelephone(String p_telephone) throws EntitiesException{
        if (p_telephone != null && p_telephone.length() >= 10) {
            telephone = p_telephone;
        } else {
            throw new EntitiesException("Le numéro de téléphone doit avoir au moins 10 caractères");
        }
    }
    public String getTelephone() {
        return telephone;
    }
    public void setMail(String p_mail) throws EntitiesException {
        if (p_mail !=null && REGRX_MAIL.matcher(p_mail).matches()) {
            mail = p_mail;
        } else {
            throw new EntitiesException("Email invalide ou manquant");
        }
    }
    public String getMail() {
        return mail;
    }
    public void setCommentaire(String p_commentaire) {
        commentaire = p_commentaire;
    }
    public String getCommentaire() {
        return commentaire;
    }
}

