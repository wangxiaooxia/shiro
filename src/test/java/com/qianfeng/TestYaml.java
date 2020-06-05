package com.qianfeng;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;


import java.io.*;
import java.util.Map;

public class TestYaml {
    public static void main(String[] args) throws Exception {

        testJsonToYaml("F:\\aa.json","F://11.yml");
    }
    //json 转成yaml
    public static  void testJsonToYaml(String json_url,String yaml_url) throws Exception {
        String param = readJson(json_url);
        createYaml(yaml_url,param);
    }

    /**
     * 將json轉化為yaml格式并生成yaml文件
     * @param jsonString
     * @return
     * @throws JsonProcessingException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public static void createYaml(String yaml_url,String jsonString) throws JsonProcessingException, IOException {
        // parse JSON
        JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonString);
        // save it as YAML
        String jsonAsYaml = new YAMLMapper().writeValueAsString(jsonNodeTree);
        Yaml yaml = new Yaml();
        Map<String,Object> map = (Map<String, Object>) yaml.load(jsonAsYaml);

        createYamlFile(yaml_url, map);
    }


    /**
     * 将数据写入yaml文件
     * @param url yaml文件路径
     * @param data 需要写入的数据
     */
    public static void createYamlFile(String url,Map<String, Object> data){
        Yaml yaml = new Yaml();
        FileWriter writer;
        try {
            writer = new FileWriter(url);
            yaml.dump(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 讀取json文件并返回字符串
     *
     * @param url
     * @return
     * @throws Exception
     */
    @SuppressWarnings("resource")
    public static String readJson(String url) throws Exception {
        File file = new File(url);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(fileReader);
        String message = new String();
        String line = null;
        while ((line = bufReader.readLine()) != null) {
            message += line;
        }
        return message;
    }

    //yaml 转成json
    public void testYamlToJson (){
        Gson  gs = new Gson();
        Map<String, Object> loaded = null;
        try {
            FileInputStream fis = new FileInputStream("E:\\touping\\support-internal-project\\support-internal-project\\support-carry\\src\\main\\resources\\application.yml");
            Yaml yaml = new Yaml();
            loaded = (Map<String, Object>) yaml.load(fis);
            System.out.println(" gs.toJson(loaded) = " +  gs.toJson(loaded));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
