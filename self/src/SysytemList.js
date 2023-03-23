import React from 'react';

import axios from 'axios';

export default class SystemList extends React.Component {
  state = {
    systems: []
  }

  componentDidMount() {
    axios.get(`https://new.vyatsu.ru/sveden/common/`)
        .then(res => {
            console.log(res.data)
            // const systems = res.data;
            // this.setState({systems});
        })
  }

  render() {
    return (
        <div>
    <p>Works</p>
      </div>
    )
  }
}