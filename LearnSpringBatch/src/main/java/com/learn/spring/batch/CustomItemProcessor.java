package com.learn.spring.batch;

import org.springframework.batch.item.ItemProcessor;

import com.learn.spring.batch.model.Report;

public class CustomItemProcessor implements ItemProcessor<Report, Report> {

	public Report process(Report report) throws Exception {
		System.out.println("Processing..." + report);

		return report;
	}

}
