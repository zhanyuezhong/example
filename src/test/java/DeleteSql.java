import org.junit.Test;

import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/**
 * User: 张月忠
 * Date: 2017/8/8
 * Time: 下午5:00
 * To change this template use File | Settings | File Templates.
 */

public class DeleteSql {

    @Test
    public void test() throws Exception {
        //String names = "1.c2345";
        String prefix = "/Users/zhangyuezhong/Downloads/";

        for (int i = 1; i <= 5; i++) {
            buildSql(prefix + i + ".csv");
        }
    }

    public void buildSql(String fileName) throws Exception {
        String outName = "/Users/zhangyuezhong/Downloads/iefare_out.sql";
        File file = new File(fileName);
        File out = new File(outName);
        String sqlTemplate = "delete from ie_fare where id={0} and  dep_city={1} and arr_city={2} ; ";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        List<String> list = new ArrayList<>();
//        list.stream().filter()
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(out, true)));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(",");
            String sql = MessageFormat.format(sqlTemplate, split[0], "'" + split[1] + "'", "'" + split[2] + "'");
            writer.write(sql);
            writer.newLine();
        }
        writer.close();
        bufferedReader.close();


    }

    @Test
    public void buildOD() throws Exception {

        String inPath = "/Users/zhangyuezhong/Desktop/1.csv";
        String outPath = "/Users/zhangyuezhong/Desktop/out.md";
        File file = new File(inPath);
        File out = new File(outPath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(out, true)));
        String line;
        String template = "{0}|{1}|{2}|1|{3}";
        writer.write("始发地 | 目的地 | 刷新频率 | 状态 | 航司");
        writer.newLine();
        writer.write("---|---|---|---|---");
        writer.newLine();

        int counter = 0;
        while ((line = bufferedReader.readLine()) != null) {
            counter++;
            String[] split = line.split(",");
            String f1 = MessageFormat.format(template, split[0], split[1], "F1", split[2]);
            String f2 = MessageFormat.format(template, split[0], split[1], "F2", split[2]);
            writer.write(f1);
            writer.newLine();
            writer.write(f2);
            writer.newLine();

            if (counter % 50 == 0) {
                writer.flush();
            }
        }
        writer.close();
        bufferedReader.close();

    }

    @Test
    public void splitFile() throws Exception {
        String inPath = "/Users/zhangyuezhong/Desktop/out.md";
        String outPath = "/Users/zhangyuezhong/Desktop/upload/";
        File file = new File(inPath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        BufferedWriter writer = null;
        String line;
        int counter = 0;
        bufferedReader.readLine();
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            if (counter % 500 == 0) {//50行分一批
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
                File out = new File(outPath + counter + ".md");
                if(!out.exists()){
                    out.createNewFile();
                }
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(out, true)));
                writer.write("始发地 | 目的地 | 刷新频率 | 状态 | 航司");
                writer.newLine();
                writer.write("---|---|---|---|---");
                writer.newLine();
            }
            counter++;
            writer.write(line);
            writer.newLine();
        }
        if (writer != null)
            writer.close();
        bufferedReader.close();

    }

    @Test
    public void buildODSQL() throws Exception {
        String inPath = "/Users/zhangyuezhong/Desktop/1.csv";
        String outName = "/Users/zhangyuezhong/Desktop/odpool_out.sql";
        File file = new File(inPath);
        File out = new File(outName);

        Set<String> odSet = new HashSet<>(1999);

        String sqlTemplate = "insert into  od_pool (origin,dest,frequency,status,fare_count,airline,create_time,update_time) values ({0},{1},{2},{3},{4},{5},now(),now()); ";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(out, false)));
        String line;
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(",");

            String o = split[0];
            String d = split[1];
            odSet.add(o+","+d);
        }
        System.out.println(odSet.size());
        for(String od:odSet){
            String[] split = od.split(",");

            String o = split[0];
            String d = split[1];
            String f1 = MessageFormat.format(sqlTemplate, "'"+o+"'", "'"+d+"'",10,1,"'"+0+"'","''");
            String f2 = MessageFormat.format(sqlTemplate, "'"+o+"'", "'"+d+"'",20,1,"'"+0+"'","''");
            writer.write(f1);
            writer.newLine();
            writer.write(f2);
            writer.newLine();
        }

        writer.close();
        bufferedReader.close();

    }
}
