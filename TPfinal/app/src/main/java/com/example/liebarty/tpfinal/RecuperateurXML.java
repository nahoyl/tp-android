package com.example.liebarty.tpfinal;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ugolinir on 25/01/17.
 */
public class RecuperateurXML
{
    //Attributs
    /** Gestionnaire d'URL.*/
    private URL _gestionnaire;

    /** Page web contenant le fichier XML.*/
    private HttpURLConnection _page;

    /** Contenu xml de la page.*/
    private InputStream _xml;

    /** Décrit la dernière erreur rencontrée.*/
    private String _messageErreur;


    //Constructeurs
    /**
     * Constructeur lambda.
     * @param url : adresse web du fichier xml, null interdit.
     */
    public RecuperateurXML(String url)
    {
        try {
            _gestionnaire = new URL("http://public.ave-comics.com/gabriel/iut/images.xml");
            _page = (HttpURLConnection) _gestionnaire.openConnection();
        }
        catch(Exception e) {
            _page = null;
            _messageErreur = e.getMessage();
        }
    }


    //Méthodes
    /**
     * @return vrai si et seulement si $this est connecté à la page donné, faux snon.
     */
    public boolean estConnecte() {return _page != null;}


    /**
     * @return vrai si et seulement si l'URL indiquée a pu être récupérée en tant
     * que flux, faux sinon.
     */
    public boolean enregistrerPage()
    {
        boolean resultat;
        try {
            _xml = new BufferedInputStream(_page.getInputStream());
            resultat = true;
        }
        catch(Exception e) {
            resultat = false;
            _messageErreur = e.getMessage();
        }
        return resultat;
    }


    /**
     * @return le fichier XML située à l'adresse indiquée.
     */
    public InputStream getXML() {return _xml;}


    /**
     * @return le dernier message d'erreur rencontré.
     */
    public String getErreur(){return this._messageErreur;}


    /**
     * Ferme proprement la connection à la page.
     */
    public void deconnecter() {_page.disconnect();}

}
