package cn.xuemengzihe.hadoop.study.demo.排序;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SumMapper extends Mapper<LongWritable, Text, Text, InfoBean> {

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		StringTokenizer strToken = new StringTokenizer(line);
		InfoBean info = new InfoBean();
		info.setAccount(strToken.nextToken());
		info.setIncome(Double.parseDouble(strToken.nextToken()));
		info.setExpenses(Double.parseDouble(strToken.nextToken()));
		info.setSurplus(info.getIncome() - info.getExpenses());
		context.write(new Text(info.getAccount()), info);
	}

}
