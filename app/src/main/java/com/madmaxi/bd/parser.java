package com.madmaxi.bd;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class parser {

    public static String getTextAtId(Document doc, String id) {
        NodeList Vignettes = doc.getElementsByTagName("vignette");

        int countVignette = Vignettes.getLength();
        for (int i = 0 ; i < countVignette; i++)
        {
            Element Vignette = (Element)Vignettes.item(i);

            if (Vignette.getAttribute("id").equals(id))
            {
                String string = Vignette.getChildNodes().item(1).getTextContent().replace("\r","");
                string = string.replace("\n","");
                string = string.replace("\t","");
                return string;
            }
        }
        return "";
    }
}


