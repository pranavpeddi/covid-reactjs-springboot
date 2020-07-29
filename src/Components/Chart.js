import React from 'react';
import {HorizontalBar,Pie} from 'react-chartjs-2';
import Axios from 'axios'

class Chart extends React.Component{
    constructor()
    {
        super();
        this.state={
           dataTable:[]
        };            
    }

    
    componentDidMount()
    {
        Axios.get('http://localhost:8080/getData').then(res=>{
            this.setState({dataTable:res.data});
        })
       
    }



    render()
    {
      
        return(
            <div className="App">
       <div>
           <h2>Covid Confirmed Cases Chart StateWise</h2>
           <HorizontalBar   
           data={
            
               {
            
               labels:this.state.dataTable.map(cd=>{return cd.name}),
              
            datasets: [
              {
                label: 'Covid State Wise Cases',
                backgroundColor: '#10BC73',
                borderColor: '#10BC73',
                borderWidth: 10,
                hoverBackgroundColor: 'rgba(255,99,132,0.4)',
                hoverBorderColor: 'rgba(255,99,132,1)',
                data:this.state.dataTable.map(cd=>{return cd.confirmed})
              }
            ]
           }}  width={50} height={500} options={{maintainAspectRatio:false}}/>
          
       </div>
      <div>
          <Pie data={{labels:this.state.dataTable.map(md=>{return md.name}),
	datasets: [{
		data: this.state.dataTable.map(md=>{return md.confirmed}),
		backgroundColor: [
		'#FF6384',
		'#36A2EB',
		'#FFCE56',
        '#AA08DE',
        '#DE08A7',
        '#A7DE08',
        '#DEAA08',
        '#08D1DE',
        '#0876DE'
		],
		hoverBackgroundColor: [
		'#FF6384',
		'#36A2EB',
		'#FFCE56',
        '#AA08DE',
        '#DE08A7',
        '#A7DE08',
        '#DEAA08',
        '#08D1DE',
        '#0876DE',
        ''
		]
	}]}}/>
      </div>
           </div>
        );
    }


}

export default Chart;