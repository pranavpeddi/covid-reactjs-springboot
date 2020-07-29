import React from 'react';
import {Table} from 'react-bootstrap'
import axios from 'axios';

class CovidTable extends React.Component
{
    constructor()
    {
        super();
         this.state={
            covidData:[]
        };
    }


componentDidMount() {
    axios.get('http://localhost:8080/getData')
      .then(res => {
        this.setState({ covidData: res.data });
        console.log(res.data)
        console.log(this.state.covidData);
      });
    
  }
  

render()
{
    console.log(this.state.covidData)
    return(
        

    <Table style={{paddingRight:1500,paddingTop:1000    }} variant="light" striped bordered hover  size="sm">
    <thead>
        <tr>
            <th>Name Of The State</th>
            <th>Confirmed Cases</th>
            <th>Active Cases</th>
            <th>Recovered</th>
            <th>Deaths</th>
        </tr>
            
    </thead>
    <tbody>
        {this.state.covidData.map(cd=>
        <tr>
            <td>{cd.name}</td>
            <td>{cd.confirmed}</td>
            <td style={{color:"#139C07"}}>{cd.active}</td>
            <td style={{color:"#0D61C2"}}>{cd.recovered}</td>
            <td style={{color:"#DE0808"}}>
            {cd.deaths}
            </td>
        </tr>
            
        )}
    </tbody>
    </Table>

    );
}

}

export default CovidTable;