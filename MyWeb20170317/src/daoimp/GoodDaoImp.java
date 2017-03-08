package daoimp;

import Util.XmlRead;
import Util.XmlWrite;
import dao.GoodDao;
import entity.Good;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcl on 2017/3/5.
 */
public class GoodDaoImp implements GoodDao{
    @Override
    public void addGood(Good good) {
        Document document=null;
        Element rootElement=null;
         if(new File("good.xml").exists())
         {
            document = XmlRead.readGoodXml();
            rootElement=document.getRootElement();
         }
         else {
             document= DocumentHelper.createDocument();
             rootElement= document.addElement("goodsList");
         }
         Element elementGood= rootElement.addElement("good");
         elementGood.addAttribute("goodId",good.getGoodId());
         elementGood.addElement("goodName").setText(good.getGoodName());
         elementGood.addElement("goodPrice").setText(String.valueOf(good.getGoodPrice()));
         elementGood.addElement("goodNum").setText(String.valueOf(good.getGoodNum()));

         XmlWrite.writeGoodXml(document);


    }

    @Override
    public void deleteGood(String id) {
        Document document=XmlRead.readGoodXml();
        Element element=(Element)document.selectSingleNode("//good[@goodId='"+id+ "']");


        if (element!=null){
            element.detach();
        }
        XmlWrite.writeGoodXml(document);

    }

    @Override
    public void updateGood(Good good) {
        Document document=XmlRead.readGoodXml();
        Element element=(Element)document.selectSingleNode("//good[@goodId='"+good.getGoodId()+"']");
        element.element("goodName").setText(good.getGoodName());
        element.element("goodPrice").setText(String.valueOf(good.getGoodPrice()));
        element.element("goodNum").setText(String.valueOf(good.getGoodNum()));

        XmlWrite.writeGoodXml(document);
    }

    @Override
    public Good findById(String id) {
        Document document=XmlRead.readGoodXml();
        Element element=(Element)document.selectSingleNode("//good[@goodId='"+id+"']");
        Good good=new Good();
        good.setGoodId(element.attributeValue("goodId"));
        good.setGoodName(element.elementText("goodName"));
        good.setGoodNum(Integer.parseInt(element.elementText("goodNum")));
        good.setGoodPrice(Double.parseDouble(element.elementText("goodPrice")));
        return good;
    }

    @Override
    public List<Good> findAll() {
        Document document=XmlRead.readGoodXml();
        List<Good> goodList = new ArrayList<Good>();
        List<Element> list= (List<Element>) document.selectNodes("//good");
        for (Element element:list
             ) {
            Good good=new Good();
            good.setGoodId(element.attributeValue("goodId"));
            good.setGoodName(element.elementText("goodName"));
            good.setGoodPrice(Double.parseDouble(element.elementText("goodPrice")) );
            good.setGoodNum(Integer.parseInt(element.elementText("goodNum")) );
            goodList.add(good);
        }

        return goodList;
    }
}
