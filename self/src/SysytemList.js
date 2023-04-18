import React, { createElement } from 'react';
import axios from 'axios';

export default class SystemList extends React.Component {
  ish;
 
  componentDidMount() {
    axios.get(`https://www.vyatsu.ru/biblioteka-3/elektronnaya-biblioteka/elektronno-bibliotechnyie-sistemyi.html`)
        .then(res => {
            const tp = res.data;
            this.ish = tp;
            var dc =new DOMParser().parseFromString(this.ish,"text/html");
            var dd = dc.getElementsByClassName('items')[0];
            var ff = dd.getElementsByTagName('h6');
            for(let i = 0; i < ff.length; i++){
              document.getElementById("container").innerText +=ff[i].textContent + '\n';
            }
            
      })
      
  }
  render() {
    return (
      <div id='container' class="cont">
        
      </div>
    )
  }
}