package com.example.liebarty.tpfinal;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Lit un fichier XML, avec le DOM.
 */
public class LecteurXML
{
    //Statiques
    private static final String RACINE = "images";
    private static final String IMAGE = "image";
    private static final String ID = "id";
    private static final String NOM = "name";
    private static final String DESC = "description";
    private static final String URL = "link";


    //Attributs
    private Document _document;
    private Element racine;
    private NodeList noeuds;
    private boolean _aucunProbleme;


    //Constructeur
    public  LecteurXML(InputStream flux)
    {
        this.creerDocument(flux);
        this.creerRacine();
    }


    //Méthodes
    /**
     * @return vrai si et seulement si le fichier est récupéré,
     * faux sinon.
     */
    public boolean estConvertit() {return _aucunProbleme;}


    /**
     * @return le nombre d'éléments du fichier XML.
     */
    public int getNombreImage() {return this.noeuds.getLength();}


    //Statiques
    /**
     * Convertit $flux en document.
     *
     * @param flux : représente un fichier XML, null interdit.
     */
    private void creerDocument(InputStream flux)
    {
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder dom = factory.newDocumentBuilder();
            _document = dom.parse(flux);
            _aucunProbleme = true;
       }
       catch(Exception e) {
           _aucunProbleme = false;
       }
    }

    /**
     * Fabrique l'arborescence du fichier XML.
     */
    private void creerRacine()
    {
        this.racine = _document.getDocumentElement();
        noeuds = this.racine.getElementsByTagName(RACINE);
    }
}
