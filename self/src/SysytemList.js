import React from 'react';
import split from 'react';
import axios from 'axios';

export default class SystemList extends React.Component {
  state = {
    systems: []
  }
  start;
  end;
  res  = '';
  outy;
  componentDidMount() {
    axios.get(`https://new.vyatsu.ru/sveden/common`)
        .then(res => {
            const systems = res.statusText;
            this.setState({systems});
          
        })
  }

  render() {
    return (
      <div>
          {this.state.systems}
      </div>
    )
  }
}