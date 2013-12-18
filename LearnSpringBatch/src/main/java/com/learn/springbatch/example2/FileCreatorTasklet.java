package com.learn.springbatch.example2;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class FileCreatorTasklet implements Tasklet {

	private String filePath;
	private String content;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		try {
			fileWriter = new FileWriter(filePath);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(content);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
			if (fileWriter != null) {
				fileWriter.close();
			}
		}

		return RepeatStatus.FINISHED;
	}
}
