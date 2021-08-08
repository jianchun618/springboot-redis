import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sxyh.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class testDAO {
    @Test
    public void test1() {
        ArrayList<JSONObject> list = new ArrayList<>();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", "基础信息");
                jsonObject.put("code", "base_info");
                    ArrayList<JSONObject> baseList = new ArrayList<>();
                            //1、构建性别信息
                            JSONObject baseObject1 = new JSONObject();
                                baseObject1.put("name", "性别");
                                baseObject1.put("code", "sex");
                                        ArrayList<JSONObject> sexList = new ArrayList<>();
                                            JSONObject jsonObject21 = new JSONObject();
                                            jsonObject21.put("name", "男");
                                            jsonObject21.put("code", "boy");
                                        sexList.add(jsonObject21);
                                            JSONObject jsonObject22 = new JSONObject();
                                            jsonObject22.put("name", "女");
                                            jsonObject22.put("code", "girl");
                                        sexList.add(jsonObject22);
                                baseObject1.put("children",sexList);

                            //2、民族信息
                            JSONObject baseObject2 = new JSONObject();
                                baseObject2.put("name", "民族");
                                baseObject2.put("code", "nation");
                                    ArrayList<JSONObject> nationList = new ArrayList<>();
                                        JSONObject nation1 = new JSONObject();
                                        nation1.put("name", "汉");
                                        nation1.put("code", "01");
                                    nationList.add(nation1);
                                        JSONObject nation2 = new JSONObject();
                                        nation2.put("name", "回族");
                                        nation2.put("code", "02");
                                    nationList.add(nation2);
                                baseObject2.put("children",nationList);

                            //3、年龄范围信息
                            JSONObject baseObject3 = new JSONObject();
                                    baseObject3.put("name", "年龄");
                                    baseObject3.put("code", "cur_age_scope");
                                        ArrayList<JSONObject> ageList = new ArrayList<>();
                                            JSONObject age1 = new JSONObject();
                                            age1.put("name", "24岁以下");
                                            age1.put("code", "01");
                                        ageList.add(age1);
                                            JSONObject age2 = new JSONObject();
                                            age2.put("name", "24-30岁");
                                            age2.put("code", "02");
                                         ageList.add(age2);
                                    baseObject3.put("children",ageList);

                            //4、婚姻状况
                            JSONObject baseObject4 = new JSONObject();
                                baseObject4.put("name", "婚姻状况");
                                baseObject4.put("code", "marriage");
                                     ArrayList<JSONObject> marriageList = new ArrayList<>();
                                                JSONObject marriage1 = new JSONObject();
                                                marriage1.put("name", "未婚");
                                                marriage1.put("code", "10");
                                            marriageList.add(marriage1);
                                                JSONObject marriage2 = new JSONObject();
                                                marriage2.put("name", "已婚");
                                                marriage2.put("code", "20");
                                        marriageList.add(marriage2);
                                 baseObject4.put("children",marriageList);
                    baseList.add(baseObject1);
                    baseList.add(baseObject2);
                    baseList.add(baseObject3);
                    baseList.add(baseObject4);
           jsonObject.put("children",baseList);
        list.add(jsonObject);
        System.out.println(JSON.toJSONString(list));

    }
    @Test
    public void test2() {
        ArrayList<JSONObject> list = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "地域信息");
        jsonObject.put("code", "area_info");
        ArrayList<JSONObject> baseList = new ArrayList<>();
        //1、户籍所在省份
        JSONObject baseObject1 = new JSONObject();
        baseObject1.put("name", "户籍所在省份");
        baseObject1.put("code", "perma_province");
            ArrayList<JSONObject> provinceList = new ArrayList<>();
                    JSONObject province1 = new JSONObject();
                    province1.put("name", "北京");
                    province1.put("code", "01");
                    provinceList.add(province1);
                    JSONObject jprovince2 = new JSONObject();
                    jprovince2.put("name", "重庆");
                    jprovince2.put("code", "02");
                    provinceList.add(jprovince2);
        baseObject1.put("children",provinceList);

        //2、户籍所在城市
        JSONObject baseObject2 = new JSONObject();
        baseObject2.put("name", "户籍所在城市");
        baseObject2.put("code", "perma_city");
                ArrayList<JSONObject> cityList = new ArrayList<>();
                JSONObject city1 = new JSONObject();
                city1.put("name", "成都市");
                city1.put("code", "01");
                cityList.add(city1);
                JSONObject city2 = new JSONObject();
                city2.put("name", "广安");
                city2.put("code", "02");
                cityList.add(city2);
        baseObject2.put("children",cityList);

        //3、身份证归属省份
        JSONObject baseObject3 = new JSONObject();
        baseObject3.put("name", "身份证归属省份");
        baseObject3.put("code", "cert_province");
        ArrayList<JSONObject> province2List = new ArrayList<>();
        JSONObject province01 = new JSONObject();
        province01.put("name", "北京");
        province01.put("code", "01");
        province2List.add(province01);
        JSONObject province02 = new JSONObject();
        province02.put("name", "重庆");
        province02.put("code", "02");
        province2List.add(province02);
        baseObject3.put("children",province2List);

        //4、身份证归属市
        JSONObject baseObject4 = new JSONObject();
        baseObject4.put("name", "身份证归属市");
        baseObject4.put("code", "cert_city");
            ArrayList<JSONObject> city2List = new ArrayList<>();
            JSONObject city01 = new JSONObject();
            city01.put("name", "成都市");
            city01.put("code", "01");
            city2List.add(city01);
            JSONObject city02 = new JSONObject();
            city02.put("name", "广安");
            city02.put("code", "02");
            city2List.add(city2);

        baseObject4.put("children",city2List);
        baseList.add(baseObject1);
        baseList.add(baseObject2);
        baseList.add(baseObject3);
        baseList.add(baseObject4);
        jsonObject.put("children",baseList);
        list.add(jsonObject);
        System.out.println(JSON.toJSONString(list));
    }
}
