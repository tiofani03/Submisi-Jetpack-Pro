package com.tiooooo.mymovie.utils;

import com.tiooooo.mymovie.entity.movie.Movie;
import com.tiooooo.mymovie.entity.tvseries.TvSeries;

import java.util.ArrayList;

public class DataDummy {
    private static final String[][] movieData = {
            {"m01",
                    "Ad Astra",
                    "/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg",
                    "3427",
                    "6",
                    "The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown.",
                    "2019-09-17",
                    "507.351",},
            {"m02",
                    "Scoob!",
                    "/zG2l9Svw4PTldWJAzC171Y3d6G8.jpg",
                    "513",
                    "8.1",
                    "In Scooby-Doo’s greatest adventure yet, see the never-before told story of how lifelong friends Scooby and Shaggy first met and how they joined forces with young detectives Fred, Velma, and Daphne to form the famous Mystery Inc. Now, with hundreds of cases solved, Scooby and the gang face their biggest, toughest mystery ever: an evil plot to unleash the ghost dog Cerberus upon the world. As they race to stop this global “dogpocalypse,” the gang discovers that Scooby has a secret legacy and an epic destiny greater than anyone ever imagined.",
                    "2020-05-15",
                    "258.564"},
            {"m03",
                    "Bloodshot",
                    "/8WUVHemHFH2ZIP6NWkwlHWsyrEL.jpg",
                    "2324",
                    "7.1",
                    "After he and his wife are murdered, marine Ray Garrison is resurrected by a team of scientists. Enhanced with nanotechnology, he becomes a superhuman, biotech killing machine—'Bloodshot'. As Ray first trains with fellow super-soldiers, he cannot recall anything from his former life. But when his memories flood back and he remembers the man that killed both him and his wife, he breaks out of the facility to get revenge, only to discover that there's more to the conspiracy than he thought.",
                    "2020-03-05",
                    "160"},
            {"m04",
                    "The Wrong Missy",
                    "/A2YlIrzypvhS3vTFMcDkG3xLvac.jpg",
                    "218",
                    "6.1",
                    "A guy meets the woman of his dreams and invites her to his company's corporate retreat, but realizes he sent the invite to the wrong person.",
                    "2020-05-13",
                    "107.286"},
            {"m05",
                    "Extraction",
                    "/wlfDxbGEsW58vGhFljKkcR5IxDj.jpg",
                    "2037",
                    "7.5",
                    "Tyler Rake, a fearless mercenary who offers his services on the black market, embarks on a dangerous mission when he is hired to rescue the kidnapped son of a Mumbai crime lord…",
                    "2020-04-24",
                    "114.479"},
            {"m06",
                    "1917",
                    "/AuGiPiGMYMkSosOJ3BQjDEAiwtO.jpg",
                    "4967",
                    "7.9",
                    "At the height of the First World War, two young British soldiers must cross enemy territory and deliver a message that will stop a deadly attack on hundreds of soldiers.",
                    "2019-12-25",
                    "104.871"},
            {"m07",
                    "Sonic the Hedgehog",
                    "/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg",
                    "4038",
                    "7.5",
                    "Based on the global blockbuster videogame franchise from Sega, Sonic the Hedgehog tells the story of the world’s speediest hedgehog as he embraces his new home on Earth. In this live-action adventure comedy, Sonic and his new best friend team up to defend the planet from the evil genius Dr. Robotnik and his plans for world domination.",
                    "2020-02-12",
                    "107.574"},
            {"m08",
                    "Birds of Prey (and the Fantabulous Emancipation of One Harley Quinn)",
                    "/kvbbK2rLGSJh9rf6gg1i1iVLYQS.jpg",
                    "3959",
                    "7.2",
                    "Harley Quinn joins forces with a singer, an assassin and a police detective to help a young girl who had a hit placed on her after she stole a rare diamond from a crime lord.",
                    "2020-02-05",
                    "113.276"},
            {"m09",
                    "Justice League Dark: Apokolips War",
                    "/c01Y4suApJ1Wic2xLmaq1QYcfoZ.jpg",
                    "418",
                    "8.5",
                    "Earth is decimated after intergalactic tyrant Darkseid has devastated the Justice League in a poorly executed war by the DC Super Heroes. Now the remaining bastions of good – the Justice League, Teen Titans, Suicide Squad and assorted others – must regroup, strategize and take the war to Darkseid in order to save the planet and its surviving inhabitants.",
                    "2020-05-05",
                    "89.083"},
            {"m10",
                    "Star Wars: The Rise of Skywalker",
                    "/db32LaOibwEliAmSL2jjDF6oDdj.jpg",
                    "4619",
                    "6.5",
                    "The surviving Resistance faces the First Order once again as the journey of Rey, Finn and Poe Dameron continues. With the power and knowledge of generations behind them, the final battle begins.",
                    "2019-12-18",
                    "90.271"}
    };
    private static final String[][] tvSeriesData = {

            {"t01",
                    "The Flash",
                    "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                    "4442",
                    "7.3",
                    "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                    "2014-10-07",
                    "254.385"},

            {"t02",
                    "The 100",
                    "/wcaDIAG1QdXQLRaj4vC1EFdBT2.jpg",
                    "2477",
                    "7.2",
                    "100 years in the future, when the Earth has been abandoned due to radioactivity, the last surviving humans live on an ark orbiting the planet — but the ark won't last forever. So the repressive regime picks 100 expendable juvenile delinquents to send down to Earth to see if the planet is still habitable.",
                    "2014-03-19",
                    "185.18"},

            {"t03",
                    "Law & Order: Special Victims Unit",
                    "/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                    "1103",
                    "7",
                    "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
                    "1999-09-20",
                    "175.867"},

            {"t04",
                    "The Simpsons",
                    "/qcr9bBY6MVeLzriKCmJOv1562uY.jpg",
                    "3361",
                    "7.4",
                    "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                    "1989-12-17",
                    "125.909"},

            {"t05",
                    "Rick and Morty",
                    "/8kOWDBK6XlPUzckuHDo3wwVRFwt.jpg",
                    "2402",
                    "8.7",
                    "Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.",
                    "2013-12-02",
                    "119.059"},

            {"t06",
                    "Resurrection: Ertugrul",
                    "/rOar34cNLn2sgDH5FmAa1bvMpBv.jpg",
                    "46",
                    "7.2",
                    "Ertuğrul Bey and the Knights Templar in the 13th century Alba and step and step with the struggle against brutal Mongols depicts the process of establishing the Ottoman principality.",
                    "2014-12-11",
                    "101.631"},

            {"t07",
                    "NCIS",
                    "/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg",
                    "1017",
                    "7",
                    "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                    "2003-09-23",
                    "109.434"},

            {"t08",
                    "Supernatural",
                    "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                    "2896",
                    "7.8",
                    "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
                    "2005-09-13",
                    "103.633"},

            {"t09",
                    "Breaking Bad",
                    "/ggFHVNu6YYI5L9pCfOacjizRGt.jpg",
                    "4580",
                    "8.6",
                    "When Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime.",
                    "2008-01-20",
                    "106.932"},

            {"t10",
                    "Grey's Anatomy",
                    "/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
                    "2167",
                    "7.5",
                    "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                    "2005-03-27",
                    "108.396"}
    };

    public static ArrayList<Movie> getMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        Movie movie;

        for (String[] data : movieData) {
            movie = new Movie();
            movie.setId(data[0]);
            movie.setTitle(data[1]);
            movie.setImg(data[2]);
            movie.setVote_count(data[3]);
            movie.setVote_avg(Double.valueOf(data[4]));
            movie.setDesc(data[5]);
            movie.setRelease_date(data[6]);
            movie.setPopularity(Double.valueOf(data[7]));
            movies.add(movie);
        }
        return movies;
    }

    public static ArrayList<TvSeries> getTvSeries() {
        ArrayList<TvSeries> tvSeries = new ArrayList<>();
        TvSeries tvShow;
        for (String[] data : tvSeriesData) {
            tvShow = new TvSeries();
            tvShow.setId(data[0]);
            tvShow.setName(data[1]);
            tvShow.setImg(data[2]);
            tvShow.setVote_count(data[3]);
            tvShow.setVote_avg(Double.valueOf(data[4]));
            tvShow.setDesc(data[5]);
            tvShow.setFirst_air_date(data[6]);
            tvShow.setPopularity(Double.valueOf( data[7]));
            tvSeries.add(tvShow);
        }
        return tvSeries;
    }
}
