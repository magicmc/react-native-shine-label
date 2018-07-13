
# react-native-shine-label
## Demo come first
<img src="https://github.com/magicmc/react-native-shine-label/blob/master/demo.gif" width="250" height="420" />

## Getting started
<!-- ## Not work yet
`$ npm install react-native-shine-label --save` -->

### Mostly automatic installation

1. git clone  https://github.com/magicmc/react-native-shine-label
2. add `"react-native-shine-label": "file:./lib/react-native-shine-label"` in package.json
3. run `react-native link react-native-shine-label`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-shine-label` and add `RNShineLabelReactNative.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNShineLabelReactNative.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNShineLabelReactNativePackage;` to the imports at the top of the file
  - Add `new RNShineLabelReactNativePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-shine-label'
  	project(':react-native-shine-label').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-shine-label/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-shine-label')
  	```


## Usage
```javascript
import ShineLabelView from 'react-native-shine-label';


<ShineLabelView ref={( self ) => { this.shineLabelView = self  }}  style={{height:200, width:200}} autoStart={true} text="just a sample" fontColor="#00BBFF" font="Roboto-MediuM" fontSize={20} />

this.shineLabelView.shine();
this.shineLabelView.fadeOut();
// TODO: What to do with the module?
  