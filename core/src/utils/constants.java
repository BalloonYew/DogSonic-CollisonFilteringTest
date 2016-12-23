/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author prudm7411
 */
public final class constants {
    //scales down everything

    public static final float PPM = 32;
    
//00000001 = 1
//00000010 = 2
//00000100 = 4
//00001000 = 8
  
    // bits for collison filtering
    public static final short Bit_Platform = 2;
    public static final short Bit_Player = 4;
    public static final short Bit_Enemy = 8;
     public static final short Bit_EnemyWalls = 16;
      public static final short Bit_Map = 32;
     
    
    
//      public static final short Bit_Platform =0x0002;
//    public static final short Bit_Player = 0x0004;
//    public static final short Bit_Enemy = 0x0008;
//     public static final short Bit_EnemyWalls = 0x00016;
}
