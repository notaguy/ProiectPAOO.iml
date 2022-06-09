package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Piesa12Tile extends Tile{
    public Piesa12Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.piesa12, id);
    }

    /*! \fn public boolean IsSolid()
        \brief Suprascrie metoda IsSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
     */
    @Override
    public boolean IsSolid()
    {
        return true;
    }

}
