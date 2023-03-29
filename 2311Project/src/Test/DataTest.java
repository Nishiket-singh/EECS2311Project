package Test;


import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import Data.*;

class DataTest {
	
	@Test
	void Category_Test() throws ClassNotFoundException {
		Business b = new Business();
		Entertainment e = new Entertainment();
		General g = new General();
		Health h = new Health();
		Science s = new Science();
		Sports p = new Sports();
		Technology t = new Technology();
		assertTrue(Class.forName("Data.Business") == b.getClass());
		assertTrue(Class.forName("Data.Entertainment") == e.getClass());
		assertTrue(Class.forName("Data.General") == g.getClass());
		assertTrue(Class.forName("Data.Health") == h.getClass());
		assertTrue(Class.forName("Data.Science") == s.getClass());
		assertTrue(Class.forName("Data.Sports") == p.getClass());
		assertTrue(Class.forName("Data.Technology") == t.getClass());
	}

	@Test
	void Business_test() {
		Business b = new Business();
		assertTrue(b.stringB.contains("Following U.S. bank failures, is it time for Canada to raise deposit insurance limits?"));
		assertTrue(b.stringB.contains("The Canada Deposit Insurance Corporation (CDIC) is a federal agency that safeguards deposits at dozens of member institutions — including Canada's biggest banks. It is funded by premiums paid by those members."));
		assertTrue(b.stringB.contains("Banking crisis lingers as contagion fears take aim at Deutsche Bank"));
	}
	
	@Test
	void Entertainment_test() {
		Entertainment e = new Entertainment();
		assertEquals(e.stringB.get(0),"On March 24, Daniel Radcliffe stepped out in New York City with his long-term girlfriend, actress Erin Darke — who appeared heavily pregnant. (See photos here.) It was the first indication that the couple of more than a decade are set to become first-time parents. A rep for the former \"Harry Potter\" child star later confirmed the happy news to multiple media outlets.");
		assertEquals(e.stringB.get(2),"Miley Cyrus and Dolly Parton's 'Rainbowland' Banned from Wisconsin Elementary School Concert");
	}
	
	@Test
	void General_test() {
		General g = new General();
		assertEquals(g.stringB.get(0),"Death toll from explosion at Pennsylvania candy factory climbs to 4 as hope of finding more survivors wanes");
		assertEquals(g.stringB.get(1),"Trump repeats false claims during rally in Waco, Texas");
		assertTrue(g.stringB.contains("Gen Z is the first generation to truly grow up online and now they’re joining the fight to log off. In February, college student and founder of the Log Off Movement, Emma Lembke, testified in front of a Senate committee about the impact that social media companies have on youth mental health. Emma is one of many activists, including parents and politicians from both sides of the aisle, calling for increased government regulation of social media companies."));
	}
	
	@Test
	void Health_test() {
		Health h = new Health();
		assertEquals(h.stringB.get(0),"Harvard Health Publishing answers: What are the signs of a dry mouth and the best remedies to treat a dry mouth?");
		assertEquals(h.stringB.get(2),"Performance: These are the healthcare stocks that outperformed their peers.");
	}
	
	@Test
	void Science_test() {
		Science s = new Science();
		assertEquals(s.stringB.get(0),"As Antarctica’s penguins struggle with record low sea ice, one species is adapting – and it offers lessons to us all");
		assertEquals(s.stringB.get(2),"A new paper says 'Oumuamua was a comet, not an alien spacecraft. Not everyone agrees");
		assertEquals(s.stringB.get(1), "An asteroid is making a close approach to Earth, and scientists are pumped");
	}
	
	@Test
	void Sports_test() {
		Sports s = new Sports();
		assertEquals(s.stringB.get(0),"Canada's Einarson captures bronze at women's curling world championship");
		assertEquals(s.stringB.get(2),"Canada's Liam Brearley wraps up World Cup snowboard season with slopestyle silver");
		assertEquals(s.stringB.get(1), "Expect Senators defenceman Tyler Kleven to make his NHL debut this week");
	}
	
	@Test
	void Technology_test() {
		Technology t = new Technology();
		assertEquals(t.stringB.get(0),"Half of students are using ChatGPT to cheat, and it could rise to 90%");
		assertEquals(t.stringB.get(2),"'X-Ray Vision' Could Be the Next Superpower You Get With Augmented Reality");
		assertEquals(t.stringB.get(1), "An asteroid is making a close approach to Earth, and scientists are pumped");
	}
	
}
