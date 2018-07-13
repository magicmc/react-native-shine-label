//
//  ShineLabelManager.h
//  HKTDCMobile
//
//  Created by magicma on 2018/7/11.
//  Copyright © 2018年 Facebook. All rights reserved.
//

#if __has_include(<React/RCTViewManager.h>)
#import <React/RCTViewManager.h>
#elif __has_include("RCTViewManager.h")
#import "RCTViewManager.h"
#else
#import "React/RCTViewManager.h"
#endif

@interface ShineLabelManager : RCTViewManager

@end

