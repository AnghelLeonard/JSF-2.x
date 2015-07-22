package beans;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.omnifaces.model.tree.ListTreeModel;

import org.omnifaces.model.tree.TreeModel;

@Named
@ViewScoped
public class TreeBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String example_1 = "{\n"
            + "    \"red\":\"#f00\",\n"
            + "    \"green\":\"#0f0\",\n"
            + "    \"blue\":\"#00f\",\n"
            + "    \"cyan\":\"#0ff\",\n"
            + "    \"magenta\":\"#f0f\",\n"
            + "    \"yellow\":\"#ff0\",\n"
            + "    \"black\":\"#000\"\n"
            + "}";
    private static final String example_2 = "{\n"
            + "    \"colorsArray\":[{\n"
            + "            \"red\":\"#f00\",\n"
            + "            \"green\":\"#0f0\",\n"
            + "            \"blue\":\"#00f\",\n"
            + "            \"cyan\":\"#0ff\",\n"
            + "            \"magenta\":\"#f0f\",\n"
            + "            \"yellow\":\"#ff0\",\n"
            + "            \"black\":\"#000\"\n"
            + "        }\n"
            + "    ]\n"
            + "}";
    private static final String example_3 = "{\n"
            + "    \"ResultSet\": {\n"
            + "        \"totalResultsAvailable\": \"1827221\",\n"
            + "        \"totalResultsReturned\": 2,\n"
            + "        \"firstResultPosition\": 1,\n"
            + "        \"Result\": [\n"
            + "            {\n"
            + "                \"Title\": \"potato jpg\",\n"
            + "                \"Summary\": \"Kentang Si bungsu dari keluarga Solanum tuberosum L ini ternyata memiliki khasiat untuk mengurangi kerutan  jerawat  bintik hitam dan kemerahan pada kulit  Gunakan seminggu sekali sebagai\",\n"
            + "                \"Url\": \"http://www.mediaindonesia.com/spaw/uploads/images/potato.jpg\",\n"
            + "                \"ClickUrl\": \"http://www.mediaindonesia.com/spaw/uploads/images/potato.jpg\",\n"
            + "                \"RefererUrl\": \"http://www.mediaindonesia.com/mediaperempuan/index.php?ar_id=Nzkw\",\n"
            + "                \"FileSize\": 22630,\n"
            + "                \"FileFormat\": \"jpeg\",\n"
            + "                \"Height\": \"362\",\n"
            + "                \"Width\": \"532\",\n"
            + "                \"Thumbnail\": {\n"
            + "                    \"Url\": \"http://thm-a01.yimg.com/nimage/557094559c18f16a\",\n"
            + "                    \"Height\": \"98\",\n"
            + "                    \"Width\": \"145\"\n"
            + "                }\n"
            + "            },\n"
            + "            {\n"
            + "                \"Title\": \"potato jpg\",\n"
            + "                \"Summary\": \"Introduction of puneri aloo This is a traditional potato preparation flavoured with curry leaves and peanuts and can be eaten on fasting day  Preparation time   10 min\",\n"
            + "                \"Url\": \"http://www.infovisual.info/01/photo/potato.jpg\",\n"
            + "                \"ClickUrl\": \"http://www.infovisual.info/01/photo/potato.jpg\",\n"
            + "                \"RefererUrl\": \"http://sundayfood.com/puneri-aloo-indian-%20recipe\",\n"
            + "                \"FileSize\": 119398,\n"
            + "                \"FileFormat\": \"jpeg\",\n"
            + "                \"Height\": \"685\",\n"
            + "                \"Width\": \"1024\",\n"
            + "                \"Thumbnail\": {\n"
            + "                    \"Url\": \"http://thm-a01.yimg.com/nimage/7fa23212efe84b64\",\n"
            + "                    \"Height\": \"107\",\n"
            + "                    \"Width\": \"160\"\n"
            + "                }\n"
            + "            }\n"
            + "        ]\n"
            + "    }\n"
            + "}";
    private static final String example_4 = "{\n"
            + "    \"glossary\": {\n"
            + "        \"title\": \"example glossary\",\n"
            + "		\"GlossDiv\": {\n"
            + "            \"title\": \"S\",\n"
            + "			\"GlossList\": {\n"
            + "                \"GlossEntry\": {\n"
            + "                    \"ID\": \"SGML\",\n"
            + "					\"SortAs\": \"SGML\",\n"
            + "					\"GlossTerm\": \"Standard Generalized Markup Language\",\n"
            + "					\"Acronym\": \"SGML\",\n"
            + "					\"Abbrev\": \"ISO 8879:1986\",\n"
            + "					\"GlossDef\": {\n"
            + "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n"
            + "						\"GlossSeeAlso\": [\"GML\", \"XML\"]\n"
            + "                    },\n"
            + "					\"GlossSee\": \"markup\"\n"
            + "                }\n"
            + "            }\n"
            + "        }\n"
            + "    }\n"
            + "}";
    private TreeModel<String> tree;

    @PostConstruct
    public void init() {

        tree = new ListTreeModel<>();

        ObjectMapper mapper = new ObjectMapper();
        try {
            //JsonNode jsonNode = mapper.readTree(example_1);
            //JsonNode jsonNode = mapper.readTree(example_2);
            //JsonNode jsonNode = mapper.readTree(example_3);
            JsonNode jsonNode = mapper.readTree(example_4);
            walker(null, jsonNode, tree);
        } catch (IOException ex) {
            Logger.getLogger(TreeBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void walker(String name, JsonNode node, TreeModel<String> tree) {

        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> iterator = node.fields();
            ArrayList<Map.Entry<String, JsonNode>> nodesList = Lists.newArrayList(iterator);

            for (Map.Entry<String, JsonNode> nodEntry : nodesList) {

                String nameName = nodEntry.getKey();
                JsonNode newNode = nodEntry.getValue();

                if (newNode.isObject()) {
                    walker(null, newNode, tree.addChild(nameName));
                } else if (newNode.isValueNode()) {
                    tree.addChild(nameName + ":" + newNode.asText());
                } else {
                    walker(nameName, newNode, tree);
                }
            }
        } else if (node.isArray()) {
            TreeModel<String> treea = tree.addChild(name);
            Iterator<JsonNode> arrayItemsIterator = node.elements();
            ArrayList<JsonNode> arrayItemsList = Lists.newArrayList(arrayItemsIterator);
            for (JsonNode arrayNode : arrayItemsList) {
                walker(null, arrayNode, treea);
            }
        } else {
            if (node.isValueNode()) {
                tree.addChild(node.asText());
            } else {
                tree.addChild("OTHER_TYPE");
            }
        }
    }

    public TreeModel<String> getTree() {
        return tree;
    }
}
