import React from 'react';
import axios from 'axios';

export default class SystemList extends React.Component {
  ish;
  res =[];
  componentDidMount() {
    axios.get(`https://new.vyatsu.ru/sveden/common`)
        .then(res => {
            const tp = res.data;
            this.ish = tp;
            console.log(this.ish);
        })
        
        
  }
  findAddresses() {
    const regex = /\d{6},/ //\w+ \w+, г. \w+, \w+. \w+, \w. \d{1,2,3}\d\S+/;
    let match;  
    while ((match = regex.exec(this.ish))) {
      this.res.push(match);
    }
  }
  render() {
    return (
      <div> 
        {this.ish}
        
          
      </div>
    )
  }
}