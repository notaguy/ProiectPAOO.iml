package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Tile
{
    private static final int NO_TILES   = 1000;
    public static Tile[] tiles          = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/

        /// De remarcat ca urmatoarele dale sunt statice si publice. Acest lucru imi permite sa le am incarcate
        /// o singura data in memorie


    public static Tile viataTile       = new ViataTile(103);

    public static Tile fundalTile         = new FundalTile(39);

    public static Tile piesa11Tile       = new Piesa11Tile(40);
    public static Tile piesa12Tile       = new Piesa12Tile(41);
    public static Tile piesa13Tile       = new Piesa13Tile(50);
    public static Tile piesa14Tile       = new Piesa14Tile(51);

    public static Tile piesa21Tile       = new Piesa21Tile(42);
    public static Tile piesa22Tile       = new Piesa22Tile(43);
    public static Tile piesa23Tile       = new Piesa23Tile(52);
    public static Tile piesa24Tile       = new Piesa24Tile(53);

    public static Tile piesa31Tile       = new Piesa31Tile(44);
    public static Tile piesa32Tile       = new Piesa32Tile(45);
    public static Tile piesa33Tile       = new Piesa33Tile(54);
    public static Tile piesa34Tile       = new Piesa34Tile(55);

    public static Tile piesa41Tile       = new Piesa41Tile(7);
    public static Tile piesa42Tile       = new Piesa42Tile(8);
    public static Tile piesa43Tile       = new Piesa43Tile(9);
    public static Tile piesa44Tile       = new Piesa44Tile(17);
    public static Tile piesa45Tile       = new Piesa45Tile(18);
    public static Tile piesa46Tile       = new Piesa46Tile(19);
    public static Tile piesa47Tile       = new Piesa47Tile(27);
    public static Tile piesa48Tile       = new Piesa48Tile(28);
    public static Tile piesa49Tile       = new Piesa49Tile(29);

    



    public static final int TILE_WIDTH  = 32;                       /*!< Latimea unei dale.*/
    public static final int TILE_HEIGHT = 32;                       /*!< Inaltimea unei dale.*/

    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de dala.*/
    protected final int id;                                         /*!< Id-ul unic aferent tipului de dala.*/

    /*! \fn public Tile(BufferedImage texture, int id)
        \brief Constructorul aferent clasei.

        \param image Imaginea corespunzatoare dalei.
        \param id Id-ul dalei.
     */
    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        tiles[id] = this; //elementul cu id-ul o sa fie egala cu dala facuta de noi cu id-ul respectiv
    }

    /*! \fn public void Update()
        \brief Actualizeaza proprietatile dalei.
     */
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g, int x, int y)
        \brief Deseneaza in fereastra dala.

        \param g Contextul grafic in care sa se realizeze desenarea
        \param x Coordonata x in cadrul ferestrei unde sa fie desenata dala
        \param y Coordonata y in cadrul ferestrei unde sa fie desenata dala
     */
    public void Draw(Graphics g, int x, int y)
    {
            /// Desenare dala
        g.drawImage(img, x, y, null);
    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
     */
    public boolean IsSolid()
    {
        return false;
    }

    /*! \fn public int GetId()
        \brief Returneaza id-ul dalei.
     */
    public int GetId()
    {
        return id;
    }
}
