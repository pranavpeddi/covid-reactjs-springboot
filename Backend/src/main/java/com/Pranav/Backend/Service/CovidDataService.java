package com.Pranav.Backend.Service;


import com.Pranav.Backend.Model.StateData;
import com.Pranav.Backend.Repository.StateDataRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CovidDataService {

    @Autowired
    private StateDataRepository stateDataRepository;


    public void saveData() throws IOException
    {
        final String url="https://www.mygov.in/covid-19";
        Document document= Jsoup.connect(url).get();
        System.out.println(document.title());
        //#state-covid-data    #state-covid-data > tbody #state-covid-data > tbody > tr:nth-child(1)
        List<StateData> stList=new ArrayList<>();
        for(Element row:document.select("#state-covid-data tr"))
        {

           StateData stateData=new StateData();

            //names
            if(row.select("td:nth-child(1)").text().equals(""))
            {
                continue;
            }
            else
            {

                stateData.setName(row.select("td:nth-child(1)").text());
            }

            //confirmed

            if(row.select("td:nth-child(2)").text().equals(""))
            {
                continue;
            }
            else
            {

                stateData.setConfirmed(Long.parseLong(row.select("td:nth-child(2)").text().replaceAll(",","")));
            }

            //active
            if(row.select("td:nth-child(3)").text().equals(""))
            {
                continue;
            }
            else
            {
                stateData.setActive(Long.parseLong(row.select("td:nth-child(3)").text().replaceAll(",","")));
            }


            //active

            if(row.select("td:nth-child(4)").text().equals(""))
            {
                continue;
            }
            else
            {
                stateData.setRecovered(Long.parseLong(row.select("td:nth-child(4)").text().replaceAll(",","")));
            }



            //
            if(row.select("td:nth-child(5)").text().equals(""))
            {
                continue;
            }
            else
            {
                stateData.setDeaths(Long.parseLong(row.select("td:nth-child(5)").text().replaceAll(",","")));
            }


            //  st1.setRecovered(Long.parseLong(row.select("td:nth-child(4)").text().replaceAll(",","")));
            //  st1.setDeaths(Long.parseLong(row.select("td:nth-child(4)").text().replaceAll(",","")));
            stList.add(stateData);

            stateDataRepository.save(stateData);
        }

        for(StateData st:stList)
        {
            System.out.println(st);
        }



    }
    }

