package com.prud.converter;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.prud.model.Answer;
import com.prud.model.Question;

public class XMLTOObject {

	public static void main(String[] args) throws Exception {
		try {

			File file = null;
			file = new File(XMLTOObject.class.getClassLoader().getResource("question.xml").toURI());
			JAXBContext jaxbContext = JAXBContext.newInstance(Question.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Question que = (Question) jaxbUnmarshaller.unmarshal(file);

			System.out.println(que.getId() + " " + que.getQuestionName());
			System.out.println("Answers:");
			List<Answer> list = que.getAnswers();
			for (Answer ans : list) {
				System.out.println(ans.getId() + " " + ans.getAnswername() + "  " + ans.getPostedby());
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
