//
//  ShineLabelManager.m
//  HKTDCMobile
//
//  Created by magicma on 2018/7/11.
//  Copyright © 2018年 Facebook. All rights reserved.
//

#import "ShineLabelManager.h"
#import "RQShineLabel.h"

#if __has_include(<React/RCTBridge.h>)
#import <React/RCTBridge.h>
#elif __has_include("RCTBridge.h")
#import "RCTBridge.h"
#else
#import "React/RCTBridge.h"
#endif

// import RCTUIManager.h
#if __has_include(<React/RCTUIManager.h>)
#import <React/RCTUIManager.h>
#elif __has_include("RCTUIManager.h")
#import "RCTUIManager.h"
#else
#import "React/RCTUIManager.h"
#endif

@implementation ShineLabelManager
RCT_EXPORT_MODULE();
RCT_EXPORT_VIEW_PROPERTY(text, NSString)
RCT_EXPORT_VIEW_PROPERTY(fontColor, NSString)
RCT_EXPORT_VIEW_PROPERTY(autoStart, BOOL)

RCT_CUSTOM_VIEW_PROPERTY(font, NSString, RQShineLabel)
{
  [view setFont:[UIFont fontWithName:json size:view.font.pointSize]];
}
RCT_CUSTOM_VIEW_PROPERTY(fontSize, int, RQShineLabel)
{
  [view setFont:[UIFont fontWithName:view.font.fontName size:[json intValue]]];
}


- (UIView *)view
{
  RQShineLabel *label = [[RQShineLabel alloc] init];
  [label setNumberOfLines:0];
  return label;
}

RCT_EXPORT_METHOD(shine:(nonnull NSNumber *)reactTag)
{

  [self.bridge.uiManager addUIBlock:^(__unused RCTUIManager *uiManager, NSDictionary<NSNumber *, UIView *> *viewRegistry) {
  
    id view = viewRegistry[reactTag];
    RQShineLabel *shineLabel = (RQShineLabel *)view;
    [shineLabel shine];
    
  }];
}

RCT_EXPORT_METHOD(fadeOut:(nonnull NSNumber *)reactTag)
{
  [self.bridge.uiManager addUIBlock:^(__unused RCTUIManager *uiManager, NSDictionary<NSNumber *, UIView *> *viewRegistry) {
    id view = viewRegistry[reactTag];
    RQShineLabel *shineLabel = (RQShineLabel *)view;
    [shineLabel fadeOut];
  }];
}

@end
