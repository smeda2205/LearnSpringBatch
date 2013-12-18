package com.learn.springbatch.example2;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class Main {
	public static void main(String[] args) throws Exception {
		CommandLineJobRunner.main(new String[]{"fileCreatorJob.xml", "fileWritingJob"});
	}
}
