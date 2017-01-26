package com.example.liebarty.tpfinal;

import android.util.Log;

import com.example.liebarty.tpfinal.ItemImage.Categorie;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
    private NodeList _noeuds;
    private boolean _aucunProbleme;
    private Categorie _liste;


    //Constructeur
    public  LecteurXML(InputStream flux)
    {
        this.creerDocument(flux);
        this.creerRacine();
        if(_aucunProbleme)
            this.recupererDonnees();
        else Log.i("Erreur donnee", "Erreur");
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
    public int getNombreImage() {return this._noeuds.getLength();}


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
        //_noeuds = this.racine.getElementsByTagName(RACINE);
    }

    private void recupererDonnees(){

        racine.normalize();

        _liste = new Categorie();

        _noeuds = _document.getElementsByTagName(RACINE);

        for (int i=0; i<_noeuds.getLength(); i++) {

            Node node = _noeuds.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element2 = (Element) node;
                String nom = getValue(NOM, element2);
                String desc = getValue(DESC, element2);
                RecuperateurPageWeb rpw = new RecuperateurPageWeb(getValue(URL, element2));
                InputStream is = rpw.getInputStream();

                _liste.addImage(nom, desc, is);
            }
        }
    }

    private static String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    public Categorie getListeImage(){
        return _liste;
    }
}
