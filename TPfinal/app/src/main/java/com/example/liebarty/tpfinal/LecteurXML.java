package com.example.liebarty.tpfinal;

import org.w3c.dom.Document;

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
    private boolean _aucunProbleme;

    //Constructeur
    public  LecteurXML(InputStream flux)
    {
        this.creerDocument(flux);
    }


    //Méthodes
    


    //Statiques
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
}
