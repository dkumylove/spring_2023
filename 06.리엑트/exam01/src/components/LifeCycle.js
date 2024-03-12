import { Component } from 'react';

class LifeCycle extends Component {
  state = {
    number: 0,
    color: 'black',
  };

  static getDerivedStateFromProps(nextProps, prevState) {
    if (nextProps.color === 'orange') {
      return { color: nextProps.color };
    }

    return null;
  }

  componentDidMount() {
    console.log('componentDidMount');
  }

  /*
  shouldComponentUpdate(nextProps, nextState) {
    if (nextState.number % 2 === 1) {
      return false;
    }

    return true;
  }
  */

  getSnapshotBeforeUpdate(prevProps, prevState) {
    return 'snapshot';
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    console.log('componentDidUpdate');
    console.log('snapshot', snapshot);
    console.log('prevState', prevState);
  }

  render() {
    console.log('render');
    const result = false;
    if (!result) {
      throw new Error('에러 발생!!!!');
    }

    const { number, color } = this.state;
    return (
      <>
        <h1>{number}</h1>
        <h2>{color}</h2>
        <button
          type="button"
          onClick={() => this.setState({ number: number - 1, color })}
        >
          -1
        </button>
        <button
          type="button"
          onClick={() => this.setState({ number: number + 1, color })}
        >
          +1
        </button>
      </>
    );
  }
}

export default LifeCycle;