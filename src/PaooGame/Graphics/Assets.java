package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.

    public static BufferedImage[] playerDown;
    public static BufferedImage[] playerUp;
    public static BufferedImage[] playerLeft;
    public static BufferedImage[] playerRight;

    public static BufferedImage[] button_start;
    public static BufferedImage[] button_continue;
    public static BufferedImage[] button_exit;
    public static BufferedImage[] button_info;
    public static BufferedImage[] button_save;
    public static BufferedImage[] button_resume;

    public static BufferedImage asteroid;
    public static BufferedImage player;

    public static BufferedImage mancare;
    public static BufferedImage piulita;
    public static BufferedImage surub;

    public static BufferedImage viata;
    public static BufferedImage fundall;
    public static BufferedImage racheta;

    public static BufferedImage sat1;
    public static BufferedImage sat2;
    public static BufferedImage sat3;
    public static BufferedImage sat4;
    public static BufferedImage sat5;

    public static BufferedImage antena1;
    public static BufferedImage antena2;
    public static BufferedImage antena3;
    public static BufferedImage antena4;
    public static BufferedImage antena5;

    //piesa1
    public static BufferedImage piesa11;
    public static BufferedImage piesa12;
    public static BufferedImage piesa13;
    public static BufferedImage piesa14;
    //piesa2
    public static BufferedImage piesa21;
    public static BufferedImage piesa22;
    public static BufferedImage piesa23;
    public static BufferedImage piesa24;
    //piesa3
    public static BufferedImage piesa31;
    public static BufferedImage piesa32;
    public static BufferedImage piesa33;
    public static BufferedImage piesa34;
    //piesa4
    public static BufferedImage piesa41;
    public static BufferedImage piesa42;
    public static BufferedImage piesa43;
    public static BufferedImage piesa44;
    public static BufferedImage piesa45;
    public static BufferedImage piesa46;
    public static BufferedImage piesa47;
    public static BufferedImage piesa48;
    public static BufferedImage piesa49;

        /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("D:\\FACULTATE\\Anul2\\Semestrul 2\\joc PAOO\\o varianta de inceput\\SPACE-SAT\\res\\textures\\spritesheet.png"));
        SpriteSheetP sheet1 = new SpriteSheetP(ImageLoader.LoadImage("D:\\FACULTATE\\Anul2\\Semestrul 2\\joc PAOO\\o varianta de inceput\\SPACE-SAT\\res\\textures\\player.png"));
        SpriteSheetB sheet2 = new SpriteSheetB(ImageLoader.LoadImage("D:\\FACULTATE\\Anul2\\Semestrul 2\\joc PAOO\\o varianta de inceput\\SPACE-SAT\\res\\textures\\menubuttons.png"));
        SpriteSheet64x64 sheet6 = new SpriteSheet64x64(ImageLoader.LoadImage("D:\\FACULTATE\\Anul2\\Semestrul 2\\joc PAOO\\o varianta de inceput\\SPACE-SAT\\res\\textures\\piese.png"));
        SpriteSheet64x64 sheet3 = new SpriteSheet64x64(ImageLoader.LoadImage("D:\\FACULTATE\\Anul2\\Semestrul 2\\joc PAOO\\o varianta de inceput\\SPACE-SAT\\res\\textures\\infobutton.png"));
        SpriteSheet96x96 sheet4 = new SpriteSheet96x96(ImageLoader.LoadImage("D:\\FACULTATE\\Anul2\\Semestrul 2\\joc PAOO\\o varianta de inceput\\SPACE-SAT\\res\\textures\\asteroid.png"));
        SpriteSheet128x128 sheet5 = new SpriteSheet128x128(ImageLoader.LoadImage("D:\\FACULTATE\\Anul2\\Semestrul 2\\joc PAOO\\o varianta de inceput\\SPACE-SAT\\res\\textures\\racheta.png"));
            /// Se obtin subimaginile corespunzatoare elementelor necesare.


        ////////////////////////////////////////
        sat1 = sheet6.crop(0,0);
        sat2 = sheet6.crop(1,0);
        sat3 = sheet6.crop(2,0);
        sat4 = sheet6.crop(3,0);
        sat5 = sheet6.crop(4,0);

        antena1 = sheet6.crop(0,1);
        antena2 = sheet6.crop(1,1);
        antena3 = sheet6.crop(2,1);
        antena4 = sheet6.crop(3,1);
        antena5 = sheet6.crop(4,1);

        ///////////////////////////////////////
        fundall = sheet.crop(6,4);
        racheta = sheet5.crop(0,0);
        asteroid = sheet4.crop(0,0);

        mancare = sheet.crop(4,3);
        surub = sheet.crop(5, 3);
        piulita = sheet.crop(6, 3);

        viata = sheet.crop(6,5);
        ////////////////////////////////////
        piesa11 = sheet.crop(0,4);
        piesa12 = sheet.crop(1,4);
        piesa13 = sheet.crop(0,5);
        piesa14 = sheet.crop(1,5);
        ////////////////////////////////////
        piesa21 = sheet.crop(2,4);
        piesa22 = sheet.crop(3,4);
        piesa23 = sheet.crop(2,5);
        piesa24 = sheet.crop(3,5);
        ////////////////////////////////////
        piesa31 = sheet.crop(4,4);
        piesa32 = sheet.crop(5,4);
        piesa33 = sheet.crop(4,5);
        piesa34 = sheet.crop(5,5);
        ////////////////////////////////////
        piesa41 = sheet.crop(4,0);
        piesa42 = sheet.crop(5,0);
        piesa43 = sheet.crop(6,0);
        piesa44 = sheet.crop(4,1);
        piesa45 = sheet.crop(5,1);
        piesa46 = sheet.crop(6,1);
        piesa47 = sheet.crop(4,2);
        piesa48 = sheet.crop(5,2);
        piesa49 = sheet.crop(6,2);
        /////////////////////////////////////

        button_start= new BufferedImage[2];
        button_start[0]=sheet2.crop(1,0);
        button_start[1]=sheet2.crop(1,1);

        button_continue= new BufferedImage[2];
        button_continue[0]=sheet2.crop(0,0);
        button_continue[1]=sheet2.crop(0,1);

        button_exit= new BufferedImage[2];
        button_exit[0]=sheet2.crop(2,0);
        button_exit[1]=sheet2.crop(2,1);

        button_save= new BufferedImage[2];
        button_save[0]=sheet2.crop(3,0);
        button_save[1]=sheet2.crop(3,1);

        button_resume= new BufferedImage[2];
        button_resume[0]=sheet2.crop(4,0);
        button_resume[1]=sheet2.crop(4,1);

        button_info= new BufferedImage[2];
        button_info[0]=sheet3.crop(0,0);
        button_info[1]=sheet3.crop(0,0);

        ////////////////////////////////////
        player=sheet1.crop(0,0);

        playerDown = new BufferedImage[4];
        playerDown[0]= sheet1.crop(0,0);
        playerDown[1]= sheet1.crop(1,0);
        playerDown[2]= sheet1.crop(2,0);
        playerDown[3]= sheet1.crop(3,0);

        playerUp = new BufferedImage[4];
        playerUp[0]= sheet1.crop(0,3);
        playerUp[1]= sheet1.crop(1,3);
        playerUp[2]= sheet1.crop(2,3);
        playerUp[3]= sheet1.crop(3,3);

        playerLeft = new BufferedImage[4];
        playerLeft[0]= sheet1.crop(0,1);
        playerLeft[1]= sheet1.crop(1,1);
        playerLeft[2]= sheet1.crop(2,1);
        playerLeft[3]= sheet1.crop(3,1);

        playerRight = new BufferedImage[4];
        playerRight[0]= sheet1.crop(0,2);
        playerRight[1]= sheet1.crop(1,2);
        playerRight[2]= sheet1.crop(2,2);
        playerRight[3]= sheet1.crop(3,2);

    }
}
