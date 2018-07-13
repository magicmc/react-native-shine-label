import {
    requireNativeComponent,
    findNodeHandle,
    ViewPropTypes,
    UIManager
} from 'react-native';
import React from 'react';
import PropTypes from 'prop-types';
let ShineLabel = requireNativeComponent('ShineLabel', ShineLabelView);
class ShineLabelView extends React.Component {

    constructor(props) {
        super(props);
        // this.props.navigator.setOnNavigatorEvent(this.onNavigatorEvent.bind(this));
        this.setRoot = this.setRoot.bind(this);
      }

    setRoot(shinelabel)
    {
        this.shinelabel = shinelabel;
    }

    shine = () => {
        UIManager.dispatchViewManagerCommand(findNodeHandle(this.shinelabel),UIManager.ShineLabel.Commands["shine"],[])
        // shineLabelManager["shine"](findNodeHandle(this.shinelabel));
    }

    fadeOut = () => {
        UIManager.dispatchViewManagerCommand(findNodeHandle(this.shinelabel),UIManager.ShineLabel.Commands["fadeOut"],[])
        // shineLabelManager["fadeOut"](findNodeHandle(this.shinelabel));
    }
    render() {
        return (
           <ShineLabel ref={this.setRoot} {...this.props} />
        )
      }

}


const propTypes = {
    ...ViewPropTypes,
    text: PropTypes.string,
    fontColor: PropTypes.string,
    autoStart: PropTypes.bool,
    font: PropTypes.string,
    fontSize: PropTypes.int
  };

const defaultProps = {
    fontColor: "#000000",
    autoStart: true,
    text: "Nothing to be changed, demo test bala bala bala bala bala bala bala bala bala bala bala bala",
    font: "Roboto-Medium",
    fontSize: 20
};

ShineLabelView.propTypes = propTypes;
ShineLabelView.defaultProps = defaultProps;
export default ShineLabelView;