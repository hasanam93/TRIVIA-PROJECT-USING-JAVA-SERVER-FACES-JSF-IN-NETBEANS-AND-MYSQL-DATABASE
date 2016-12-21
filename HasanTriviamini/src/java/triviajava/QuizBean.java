/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triviajava;

/**
 *
 * @author Student
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class QuizBean implements Serializable {

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

private int currentProblem;
private int i;
 private int tries;
  private int score;
  private  String response = "";
  private String correctAnswer;
  private float percentage;

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

        
  // Here, we hardwire the problems. In a real application,
  // they would come from a database
  private ArrayList<Problem> problems = new ArrayList<Problem>(Arrays.asList(
      new Problem("Science",
                "What is the product of mass and acceleration? \n 1.force \n 2.momentum \n 3.density  \n 4.volume",
              
                "force"),
       new Problem("Arts", "A painting by which artist was damaged in January 2010 when a student fell into it at the Metropolitan Museum of Art in New York?\n 1.Davinci - ‘Mona Lisa' \n 2.Picasso - ‘The Actor' \n 3.Rembrandt - 'The Nightwatch'",   "Picasso - ‘The Actor’"),
   new Problem("Science", "Who invented the electric battery in 1800? \n 1.Isaac Newton \n 2.Alessandro Volta \n 3.Thomas Edison",  "Alessandro Volta"),
       new Problem("History", "In September 1850, what was the 31st American state to join the Union?\n 1.Arkansas \n 2.Missouri \n 3.California",  "California"),
        new Problem("Entertainment", "What are the first names of US tv characters ‘Starsky and Hutch’?\n 1.David and Keith \n 2.David and Kenneth \n 3.Donnie and Kenneth", "David and Kenneth"),
        new Problem("Science", "Hinge, Saddle, Pivot and Gliding are all types of what in the human body?\n 1.Muscle \n 2.Tendon \n 3.Joint",  "Joint"),
        new Problem("Science", "Salix Babylonica is the Latin name for which tree? \n 1.Oak \n 2.Weeping willow \n 3.Elm 4.Pine",  "Weeping willow"),
        new Problem("Entertainment", "Sergeant Tibbs is the name of the barn cat in which Disney film? \n 1.Little Mermaid \n 2.Snow White \n 3.101 Dalmations",  "101 Dalmations"),
        new Problem("Entertainment", "Steve Martin and which other actor hosted the 2010 Academy Awards? \n 1.Robin Williams \n 2.Alec Baldwin \n 3.Tom Cruise",  "Alec Baldwin"),
        new Problem("General Knowledge", "Blunging, Fettling, Saggar and Wedging are all terms used in which craft? \n 1.Gardening \n 2.Pottery \n 3.Knitting",  "Pottery"),
        new Problem("Sports", "Which tennis player, born in 1946, was nicknamed ‘Nasty’? \n 1.Pancho Gonzalez \n 2.Ilie Nastase \n 3.John McEnroe",  "Ilie Nastase"),
        new Problem("Geography", "Ankara is the capital of which country? \n 1.Syria \n 2.Turkey \n 3.Iraq",  "Turkey"),
        new Problem("History", "Psychoanalyst A A Brill described what as ‘Torches of Freedom’ in the 1920’s, as symbols of equality for women? \n 1.Votes \n 2.Cigarettes \n 3.Pants",  "Cigarettes"),
        new Problem("Entertainment", "Which song by Irish band U2 is a tribute to Martin Luther King Jr?\n 1.Pride (In the Name of Love) \n 2.With or without you \n 3.Sunday Bloody Sunday",   "Pride (In the Name of Love)"),
        new Problem("Science", "Refraction concerns a changed direction of sound, radiation, or a river? \n 1.river \n 2.radiation \n 3.sound",  "radiation"),
        new Problem("History", "In which decade of the 20th Century did the Alcatraz Island federal penitentiary close? \n 1.1960’s \n 2.1950’s \n 3.1940’s",  "1960’s"),
        new Problem("Literature", "Which US author won the 1953 Pulitzer Prize for Fiction for his novel ‘The Old Man and the Sea’? \n 1.William Faulkner \n 2.Carl Sandberg \n 3.Ernest Hemingway",   "Ernest Hemingway"),
        new Problem("Entertainment", "Who played the role of J J Gittes in the 1974 film ‘Chinatown’? \n 1.Jack Nicholson \n 2.John Wayne \n 3.Roman Polanski",  "Jack Nicholson"),
        new Problem("Geography", "The Big Muddy River in Southern Illinois joins which other river? \n 1.Mississippi River \n 2.Ohio River \n 3.Missouri River",  "Mississippi River"),
        new Problem("Entertainment", "Fanfare For The Common Man’ is a work by which 20th Century composer? \n 1.Claude Debussy \n 2.Maurice Ravel \n 3.Aaran Copland",  "Aaran Copland"),
        new Problem("Geography", "What is the US state capital of Utah? \n 1.Provo \n 2.Salt Lake City \n 3.Orem", "Salt Lake City"),
        new Problem("General Knowledge", "According to the proverb, A ‘what’ is only as strong as its weakest link? \n 1.network \n 2.chain \n 3.group",  "chain"),
        new Problem("General Knowledge", "In the Catholic religion, there are how many Stations of the Cross? \n 1.14 \n 2.10 \n 3.12", "14"),
        new Problem("General Knowledge", "What colour, traditionally, are cabs in New York? \n 1.white \n 2.black \n 3.yellow", "yellow"),
        new Problem("Literature", "Who wrote the 1979 novel ‘The Executioner’s Song’? \n 1.Gore Vidal \n 2.Norman Mailer \n 3.Stephen King",  "Norman Mailer"),
        new Problem("General Knowledge", "What is the official language of Uruguay? 1.Spanish \n 2.Portuguese \n 3.English",  "Spanish"),
        new Problem("Entertainment", "Which English model was married to musicians George Harrison and Eric Clapton? \n 1.Kate Moss \n 2.Twiggy \n 3.Pattie Boyd",  "Pattie Boyd"),
        new Problem("History", "Who became English monarch in May 1660?\n 1.King Charles I \n 2.King Charles II \n 3.King William IV",  "King Charles II"),
        new Problem("General Knowledge", "The Stotinka is a unit of currency of which European country? \n 1.Bulgaria \n 2.Romania \n 3.Latvia",  "Bulgaria"),
        new Problem("Entertainment", "Ian Stewart was known as the sixth member of which British rock group? \n 1.Rolling Stones \n 2.Beatles \n 3.The Who",  "Rolling Stones"),
        new Problem("Science", "Which English scientist first described the colours of the rainbow as ‘numbering seven’? \n 1.Michael Faraday \n 2.Sir Humphrey Davy \n 3.Sir Isaac Newton",  "Sir Isaac Newton"),
        new Problem("Science", "Ranidaphobia is the irrational fear of which creatures? \n 1.Frogs \n 2.Spiders \n 3.Snakes",  "Frogs"),
        new Problem("General Knowledge", "Pearl and Moonstone are traditional modern birthstones for which month of the year? \n 1.June \n 2.July \n 3.May",  "June"),
        new Problem("General Knowledge", "What type of fish is used in making Worcestershire Sauce? \n 1.Chubs \n 2.Anchovies \n 3.Salmon", "Anchovies"),
        new Problem("Science", "What is the outer layer of human skin called? \n 1.Epidermis \n 2.Endodermis \n 3.Epicondile",  "Epidermis"),
        new Problem("General Knowledge", "Oil of Cloves is traditionally used to treat the pain in which part of the human body? \n 1.feet \n 2.teeth \n 3.back",  "teeth"),
        new Problem("Literature", "Which Swedish author was best known for writing the ‘Millennium Series’ of crime novels? \n 1.Henning Mankel \n 2.Stieg Larrson \n 3.Liza Marklund",  "Stieg Larrson"),
        new Problem("Science", "A group of which animals is known as an ‘Array’? \n 1.Hogs \n 2.Hedgehogs \n 3.Whales",  "Hedgehogs"),
        new Problem("Entertainment", "In the Disney film ‘The Lion King’ what is the name of Simba’s wicked uncle? \n 1.Lash \n 2.Scar \n 3.One-eye",  "Scar"),
        new Problem("General Knowledge", "Khalsa is an order of which religion? \n 1.Jainism \n 2.Hinduism \n 3.Sikhism",  "Sikhism"),
        new Problem("History", "Abdul Aziz Ibn Saud was the first king of which Asian state? \n 1.Saudi Arabia \n 2.UAE \n 3.Jordan",  "Saudi Arabia"),
        new Problem("Sports", "Which country hosted the 1988 Winter Olympics?\n 1.Canada \n 2.France \n 3.Russia", "Canada"),
        new Problem("Science", "In anatomy, otic relates to which part of the human body?\n 1.Foot \n 2.Ear \n 3.Eye", "Ear"),
        new Problem("History", "What type of animal was Laika, who was the first living animal to orbit the Earth in Sputnik 2, launched by Russia? \n 1.Dog \n 2.Monkey \n 3.Chimp",  "Dog"),
        new Problem("General Knowledge", "Roman Numerals CD represent which number? \n 1.400 \n 2.150 \n 3.900",  "400"),
        new Problem("History", "Who was Vice-President to US President Jimmy Carter? \n 1.Spiro Agnew \n 2.Gerald Ford \n 3.Walter Mondale",  "Walter Mondale"),
        new Problem("General Knowledge", "What is a military officer called who acts as an administrative assistant to a more senior officer? \n 1.Lieutenant \n 2.Adjutant \n 3.Aide",  "Adjutant"),
        new Problem("Entertainment", "What number is the title of singer Beyonce’s album, released in June 2011? \n 1.4 \n 2.14 \n 3.24",  "4"),
        new Problem("General Knowledge", "Spumoni is what type of foodstuff? \n 1.Cake \n 2.Ice cream \n 3.Flavored ice", "Ice cream"),
        new Problem("Sports", "In the game of snooker, what is the inside edge of the table called, against which a ball can be played? \n 1.Side \n 2.Cushion \n 3.Bumper",  "Cushion"),
        new Problem("Sports", "How wide is a volleyball court in feet? \n 1.40 feet \n 2.30 feet \n 3.50 feet",  "30 feet"),
        new Problem("Sports", "Which British golf course is known as ‘The Home of Golf’? \n 1.Royal Liverpool \n 2.St Giles \n 3.St Andrews",  "St Andrews"),
        new Problem("Geography", "Which of the Great Lakes is the only one located entirely in the United States of America? \n 1.Lake Erie \n 2.Lake Michigan \n 3.Lake Huron",  "Lake Michigan"),
        new Problem("General Knowledge", "If something is ‘septennial’, it lasts or recurs every how many years? \n 1.Seventeen \n 2.Seven \n 3.Seventy",  "Seven"),
        new Problem("Science", "Which scientist was granted 1093 US patents for his inventions? \n 1.Alexander Graham Bell \n 2.Thomas Edison \n 3.Nikola Tesla",  "Thomas Edison"),
        new Problem("General Knowledge", "Thou shall not steal’ is which number in the list of the Ten Commandments? \n 1.9th \n 2.8th \n 3.7th",  "8th"),
        new Problem("General Knowledge", "Martedi is Italian for which day of the week? \n 1.Tuesday \n 2.Thursday \n 3.Monday",  "Tuesday"),
        new Problem("Entertainment", "What is the name of the bear in the television series ‘The Muppets’? \n 1.Bert \n 2.Elmo \n 3.Fozzie", "Fozzie"),
        new Problem("General Knowledge", "Marianne’ is a national emblem of which European country? \n 1.France \n 2.Spain \n 3.Luxembourg", "France"),
        new Problem("General Knowledge", "According to the Bible, what was the name of Jesus maternal grandfather? \n 1.James \n 2.Heli \n 3.Joseph",  "Heli"),
        new Problem("History", "Which cigarette brand was launched in 1924 with the slogan ‘Mild As May’? \n 1.Kool \n 2.Kent \n 3.Marlboro",  "Marlboro"),
        new Problem("Science", "Xylology is the study of which natural substance? \n 1.Copper \n 2.Wood \n 3.Iron",  "Wood"),
        new Problem("History", "The ‘Pentagon Papers’ is a US Department of Defense history of the United States political-military involvement in which country? \n 1.Vietnam \n 2.Thailand \n 3.Tibet",  "Vietnam"),
        new Problem("Science", "A titi is what type of animal? \n 1.Bear \n 2.Monkey \n 3.Parrot",  "Monkey"),
        new Problem("General Knowledge", "What is the person called who manages the financial affairs of a college or university? \n 1.CEO \n 2.Bursar \n 3.Registrar",  "Bursar"),
        new Problem("History", "The Night of the Long Knives’ refers to which leader eliminating many of his political enemies? \n 1.Sadam Hussein \n 2.Adolph Hitler \n 3.Muammar Qaddafi",  "Adolph Hitler"),
        new Problem("History", "Kwame Nkrumah became the first President of which country in 1960? \n 1.Liberia \n 2.Ghana \n 3.Lesotho",  "Ghana"),
        new Problem("General Knowledge", "The famous sculpture ‘Le Baiser’ is known by what name in English? \n 1.The Look (of love) \n 2.The Kiss \n 3.The Breath",  "The Kiss"),
        new Problem("Geography", "In which European city is the famous Arch of Hadrian? \n 1.Naples \n 2.Athens \n 3.Rome",  "Athens"),
        new Problem("Arts", "Pineapple, Armandinho and Fluke are all types of which musical instrument? \n 1.Guitar \n 2.Ukulele \n 3.Banjo", "Ukulele"),
        new Problem("Literature", "Prince Lev Nikolaevich Myshkin was created by which author? \n 1.Fydor Dostoyevsky \n 2.Lev Tolstoy \n 3.Alexander Pushkin",  "Fydor Dostoyevsky"),
        new Problem("General Knowledge", "Coach’ is a brand name for which fashion items? \n 1.Perfume \n 2.Handbags \n 3.Shoes",  "Handbags"),
        new Problem("Science", "What type of creature is a capelin? \n 1.Fish \n 2.Bird \n 3.Reptile",  "Fish"),
        new Problem("General Knowledge", "Which two ingredients are used to make the alcoholic drink ‘Stinger’? \n 1.Brandy and green Creme de Menthe \n 2.Brandy and white Creme de Menthe \n 3.Brandy and soda",  "Brandy and white Creme de Menthe"),
        new Problem("General Knowledge", "On which part of the body would a Hwagwan be worn? \n 1.Arm \n 2.Head \n 3.Neck",  "Head"),
        new Problem("Geography", "Poland, Russia, Sweden, Latvia, Germany and Finland all have a border on which body of water? \n 1.Baltic Sea \n 2.Bering Sea \n 3.North Sea",  "Baltic Sea"),
        new Problem("Science", "How many stars make up Orion’s Belt? \n 1.Three \n 2.Five \n 3.Severn",  "Three"),
        new Problem("Entertainment", "What is the title of The Beatles first feature film, released in 1964? \n 1.Sgt. Pepper \n 2.A Hard Day’s Night \n 3.I Love You",  "A Hard Day’s Night"),
        new Problem("Entertainment", "Remy, Colette Tatou and Anton Ego are all characters in which 2007 Disney film? \n 1.Ratatouille \n 2.Little Mermaid \n 3.Mulan",  "Ratatouille"),
        new Problem("History", "What was the first name of US army officer Custer, who died at the Battle of the Little Bighorn in 1876? \n 1.Grant \n 2.George \n 3.Armstrong",  "George"),
        new Problem("General Knowledge", "Which electronics company has the motto ‘make.believe’? \n 1.Nokia \n 2.Panasonic \n 3.Sony",  "Sony"),
        new Problem("General Knowledge", "The ‘GoldenTriangle’ in Southeast Asia produces which illicit crop? \n 1.Cocaine \n 2.Opium (poppy) \n 3.Marijuana",  "Opium (poppy)"),
        new Problem("Entertainment", "Which actor became the 38th Governor of California, USA in 2003? \n 1.Arnold Schwarzenegger \n 2.Tom Cruise \n 3.Jerry Brown",  "Arnold Schwarzenegger"),
        new Problem("History", "In 1907, which ill-fated liner of the Cunard Line made its maiden voyage? \n 1.RMS Olympic \n 2.RMS Lusitania \n 3.RMS Titanic",  "RMS Lusitania"),
        new Problem("General Knowledge", "Messer is German for which item of cutlery? \n 1.Knife \n 2.Fork \n 3.Spoon",  "Knife"),
        new Problem("Sports", "What is the nickname of baseball star Jimmie Foxx? \n 1.Three-finger \n 2.Splendid Splinter \n 3.Double X",  "Double X"),
        new Problem("Geography", "What is the name of the Tropic which lies approximately 23.5 degrees south of the Equator and runs through Australia, Chile, Brazil and South Africa? \n 1.Tropic of Capricorn \n 2.Tropic of Eden \n 3.Tropic of Cancer",  "Tropic of Capricorn"),
        new Problem("Geography", "Kuala Lumpur is the capital of which country?\n 1.Thailand \n 2.Malaysia \n 3.Laos",  "Malaysia"),
        new Problem("Science", "Which animal is known as ‘The Ship of the Desert’? \n 1.LLama \n 2.Camel \n 3.Alpaca",  "Camel"),
        new Problem("Sports", "Former football player Eusebio, who died in January 2014, played for which national team? \n 1.Spain \n 2.Portugal \n 3.Brazil",  "Portugal"),
        new Problem("Science", "What is the young of a koala called? \n 1.Joey \n 2.Kid \n 3.Pup",  "Joey"),
        new Problem("History", "In 1924, which country hosted the first Winter Olympic Games? \n 1.Switzerland \n 2.France \n 3.Austria",  "France"),
        new Problem("Literature", "Which English author drowned in 1941, after filling her pockets with stones and walking into the River Ouse? \n 1.Virginia Woolf \n 2.Sylvia Plath \n 3.Agatha Cristie",  "Virginia Woolf"),
        new Problem("Science", "A durian is what type of foodstuff? \n 1.Fruit \n 2.Vegetable \n 3.Grape",  "Fruit"),
        new Problem("General Knowledge", "Which Pope was made an honorary member of the Harlem Globetrotters basketball team? \n 1.Pope Francis \n 2.Pope John Paul II \n 3.Pope John XXIII",  "Pope John Paul II"),
        new Problem("Science", "A caracal is what type of animal? \n 1.Dog \n 2.Cat \n 3.Bird",  "Cat"),
        new Problem("Entertainment", "Eddie Fisher, Michael Todd and John Warner were all married to which late Hollywood actress? \n 1.Marilyn Monroe \n 2.Elizabeth Taylor \n 3.Bette Davis",  "Elizabeth Taylor"),
        new Problem("Sports", "Texas Hold ‘Em is a variation of which card game? \n 1.Poker \n 2.Spades \n 3.Blackjack \n 2.Hearts",  "Poker"),
        new Problem("Science", "Canis Lupus Familiaris is the scientific name for which animal? \n 1.Wolf \n 2.Dog \n 3.Coyote \n 4.Hyena", "Dog"),
        new Problem("Arts", "Which composer wrote the ‘Brandenburg Concertos’?\n 1.Johann Christian Bach \n 2.Johann Sebastian Bach \n 3.Ludwig van Beethoven",  "Johann Sebastian Bach"),
        new Problem("Arts", "He sculpted the 'Pieta'.\n 1.DaVinci \n 2.Michaelangelo \n 3.Rafael \n 4.Bernini",  "Michaelangelo"),
        new Problem("Arts", "What museum is the London treasury of literature, science, and art, and the home of the Magna Carta, Rosetta Stone, and the Elgin Marbles?\n 1.MOMA \n 2.Tate Gallery \n 3.Metropolitan \n 4.British Museum",  "British Museum"),
        new Problem("Arts", "The extravagant style of art, music and architecture that developed in Italy and Spain in the 16th-17th centuries was known by what name? \n 1.Baroque 2.Rococco 3.Classical 4.Romantic",  "Baroque"),
        new Problem("Literature", "Who wrote the sci-fi novel 'Childhoods End'? \n 1.Arthur C. Clarke \n 2.Robert Heinlein \n 3.Isaac Asimov \n 4.Ben Bova",  "Arthur C. Clarke"),
        new Problem("Literature", "What word, extended from a more popular term, refers to a fictional book of between 20,000 and 50,000 words? \n 1.Ode \n 2.Roman a clef \n 3.Novel \n 4.Novella",  "Novella")));
    
  
  
          public String getQuestion() {
    return problems.get(currentProblem).getQuestion();
  }
          public String getCategories() {
    return problems.get(currentProblem).getCategories();
  }

  public String getAnswer() {
    return correctAnswer;
  }

  public int getScore() {
    return score;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String newValue) {
    response = newValue;
  }

  public String answerAction() {
    tries++;
    if (problems.get(currentProblem).isCorrect(response)) {
      score++;
        percentage = 100*score/5;
      nextProblem();
      if (i>=5) {
        return "done";
      } else {
        return "success";
      }
    } else if (tries == 1) {
      return "again";
    } else {
      nextProblem();
      if (i >= 5) {
        return "done";
      } else {
        return "failure";
      }
    }
  }

  public String startOverAction() {
    Collections.shuffle(problems);
    currentProblem = 0;
  score=0;
    tries = 0;
    i=0;
    response = "";
    return "startOver";
  }

  private void nextProblem() {
    correctAnswer = problems.get(currentProblem).getAnswer();
    currentProblem=new Random().nextInt(problems.size());
    i++;
    tries = 0;
    response = "";
  }

   

}
