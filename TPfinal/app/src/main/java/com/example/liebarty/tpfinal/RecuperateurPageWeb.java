package com.example.liebarty.tpfinal;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ugolinir on 25/01/17.
 */
public class RecuperateurPageWeb
{
    //Attributs
    /** Gestionnaire d'URL.*/
    private URL _gestionnaire;

    /** Page web contenant le fichier XML.*/
    private HttpURLConnection _page;

    /** Contenu xml de la page.*/
    private InputStream _inputStream;

    /** Décrit la dernière erreur rencontrée.*/
    private String _messageErreur;

    /** Vrai si et seulement si la récupération de la page s'est effectuée sans problème.*/
    private boolean _aucunProbleme;


    //Constructeurs
    /**
     * Constructeur lambda.
     * @param url : adresse web à chercher, null interdit.
     */
    public RecuperateurPageWeb(String url)
    {
        _aucunProbleme = this.recupererLaPage(url);
    }


    //Méthodes
    /**
     * @return vrai si et seulement si $this est connecté à la page donné, faux snon.
     */
    public boolean estConnecte() {return _aucunProbleme;}


    /**
     * @return le fichier XML située à l'adresse indiquée.
     */
    public InputStream getInputStream() {return _inputStream;}


    /**
     * @return le dernier message d'erreur rencontré.
     */
    public String getErreur(){return _messageErreur;}


    /**
     * @param url : la page à atteindre, null interdit.
     * @return vrai si et seulement si la pag a pu être atteinte et
     * enregistrée sous forme de flux.
     */
    public boolean setURL(String url) {return _aucunProbleme = recupererLaPage(url);}


    //Privées
    /**
     * Connecte l'application à $url, récupère la page sous forme de flux,
     * puis ferme la connection.
     *
     * @param url : la page à atteindre, null interdit.
     * @return vrai si et seulement si la page est récupérée, faux sinon.
     */
    private boolean recupererLaPage(String url)
    {
        boolean resultat;
        try {
            _gestionnaire = new URL(url);
            _page = (HttpURLConnection) _gestionnaire.openConnection();
            _inputStream = new BufferedInputStream(_page.getInputStream());
            resultat = true;
        }
        catch(Exception e) {
            _page = null;
            _messageErreur = e.getMessage();
            resultat = false;
        }
        finally {
            _page.disconnect();
        }
        return resultat;
    }
}
