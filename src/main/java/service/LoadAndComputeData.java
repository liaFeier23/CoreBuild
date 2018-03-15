package service;

import model.Hero;
import model.Planet;
import model.Result;
import model.Ship;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Math.round;

public class LoadAndComputeData {

    private ArrayList<Hero> characters;
    private ArrayList<Planet> planets;
    private ArrayList<Ship> ships;

    private ArrayList<Result> results = new ArrayList<>();

    public LoadAndComputeData() {
    }

    public void readJson() {

        ObjectMapper mapper = new ObjectMapper();
        try {
            characters = mapper.readValue(new File("src\\main\\resources\\characters.json"), new TypeReference<ArrayList<Hero>>(){});
            planets = mapper.readValue(new File("src\\main\\resources\\planets.json"), new TypeReference<ArrayList<Planet>>(){});
            ships = mapper.readValue(new File("src\\main\\resources\\ships.json"), new TypeReference<ArrayList<Ship>>(){});

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void construct(String heroName, int cargo, String planetName){
        Planet targetPlanet = null;
        Hero targetHero = null;

        for(Hero h : characters){
            if(heroName.equals(h.getName())){
                targetHero = new Hero(h.getId(), h.getName(), h.getShipsType());
            }
        }
        for(Planet p : planets){
            if(planetName.equals(p.getName())){
                targetPlanet = new Planet(p.getId(), p.getName(), p.getDistance());
            }
        }

        if(targetHero != null && targetPlanet != null){
            for(int i=0; i<targetHero.getShipsType().size(); i++){
                for(Ship s : ships){
                    if(s.getType() == targetHero.getShipsType().get(i)){
                        Result result = new Result();
                        result.setShipName(s.getName());
                        result.setNumberTrips(Math.round((float)cargo/s.getMaxCargoWeight()));
                        int totalTime = (Math.round((float)cargo/s.getMaxCargoWeight()) + (Math.round((float)cargo/s.getMaxCargoWeight()) - 1)) * (targetPlanet.getDistance()/s.getSpeed());
                        result.setTotalTimeTransport(totalTime);
                        results.add(result);
                    }

                }
            }
        }

        results.sort((Result r1, Result r2)->r1.getTotalTimeTransport()-r2.getTotalTimeTransport());
    }

    public ArrayList<Result> getResults() {
        return results;
    }
}
