/*
 * This file is part of WebLookAndFeel library.
 *
 * WebLookAndFeel library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebLookAndFeel library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.laf.label;

import com.alee.extended.painter.Painter;
import com.alee.laf.WebLookAndFeel;
import com.alee.managers.language.LanguageManager;
import com.alee.managers.language.LanguageMethods;
import com.alee.managers.language.LanguageUtils;
import com.alee.managers.language.updaters.LanguageUpdater;
import com.alee.managers.log.Log;
import com.alee.managers.style.StyleManager;
import com.alee.utils.ReflectUtils;
import com.alee.utils.SizeUtils;
import com.alee.utils.SwingUtils;
import com.alee.utils.laf.Styleable;
import com.alee.utils.swing.FontMethods;
import com.alee.utils.swing.SizeMethods;

import javax.swing.*;
import java.awt.*;

/**
 * This JLabel extension class provides a direct access to WebLabelUI methods.
 * It also provides a few additional constructors nad methods to setup the label.
 * <p/>
 * This component should never be used with a non-Web UIs as it might cause an unexpected behavior.
 * You could still use that component even if WebLaF is not your application L&amp;F as this component will use Web-UI in any case.
 *
 * @author Mikle Garin
 */

public class WebLabel extends JLabel implements Styleable, LanguageMethods, FontMethods<WebLabel>, SizeMethods<WebLabel>
{
    /**
     * Constructs empty label.
     */
    public WebLabel ()
    {
        super ();
    }

    /**
     * Constructs label with the specified preferences.
     *
     * @param margin label margin
     */
    public WebLabel ( final Insets margin )
    {
        super ();
        setMargin ( margin );
    }

    /**
     * Constructs label with the specified preferences.
     *
     * @param icon icon
     */
    public WebLabel ( final Icon icon )
    {
        super ( icon );
    }

    /**
     * Constructs label with the specified preferences.
     *
     * @param icon   label icon
     * @param margin label margin
     */
    public WebLabel ( final Icon icon, final Insets margin )
    {
        super ( icon );
        setMargin ( margin );
    }

    /**
     * Constructs label with the specified preferences.
     *
     * @param horizontalAlignment horizontal alignment
     */
    public WebLabel ( final int horizontalAlignment )
    {
        super ();
        setHorizontalAlignment ( horizontalAlignment );
    }

    /**
     * Constructs label with the specified preferences.
     *
     * @param horizontalAlignment horizontal alignment
     * @param margin              label margin
     */
    public WebLabel ( final int horizontalAlignment, final Insets margin )
    {
        super ();
        setHorizontalAlignment ( horizontalAlignment );
        setMargin ( margin );
    }

    /**
     * Constructs label with the specified preferences.
     *
     * @param icon                label icon
     * @param horizontalAlignment horizontal alignment
     */
    public WebLabel ( final Icon icon, final int horizontalAlignment )
    {
        super ( icon, horizontalAlignment );
    }

    /**
     * Constructs label with the specified preferences.
     *
     * @param icon                label icon
     * @param horizontalAlignment horizontal alignment
     * @param margin              label margin
     */
    public WebLabel ( final Icon icon, final int horizontalAlignment, final Insets margin )
    {
        super ( icon, horizontalAlignment );
        setMargin ( margin );
    }

    /**
     * Constructs label with the specified preferences.
     *
     * @param text text or translation key
     */
    public WebLabel ( final String text )
    {
        super ( LanguageUtils.getInitialText ( text ) );
        LanguageUtils.registerInitialLanguage ( this, text );
    }

    /**
     * todo This constructor causes compile-time issues on JDK7 and replaced with its simple version.
     * todo Reference to the issue: https://github.com/mgarin/weblaf/issues/175
     * todo Return better constructor when fully switched to JDK8+ support only
     */
    //    /**
    //     * Constructs label with the specified preferences.
    //     *
    //     * @param text text or translation key
    //     * @param data language data, may not be passed
    //     */
    //    public WebLabel ( final String text, final Object... data )
    //    {
    //        super ( LanguageUtils.getInitialText ( text, data ) );
    //        LanguageUtils.registerInitialLanguage ( this, text, data );
    //    }

    /**
     * Constructs label with the specified preferences.
     *
     * @param text   text or translation key
     * @param margin label margin
     * @param data   language data, may not be passed
     */
    public WebLabel ( final String text, final Insets margin, final Object... data )
    {
        super ( LanguageUtils.getInitialText ( text, data ) );
        LanguageUtils.registerInitialLanguage ( this, text, data );
        setMargin ( margin );
    }

    /**
     * Constructs label with the specified preferences.
     *
     * @param text                text or translation key
     * @param horizontalAlignment horizontal alignment
     * @param data                language data, may not be passed
     */
    public WebLabel ( final String text, final int horizontalAlignment, final Object... data )
    {
        super ( LanguageUtils.getInitialText ( text, data ), horizontalAlignment );
        LanguageUtils.registerInitialLanguage ( this, text, data );
    }

    /**
     * Constructs label with the specified preferences.
     *
     * @param text                text or translation key
     * @param horizontalAlignment horizontal alignment
     * @param margin              label margin
     * @param data                language data, may not be passed
     */
    public WebLabel ( final String text, final int horizontalAlignment, final Insets margin, final Object... data )
    {
        super ( LanguageUtils.getInitialText ( text, data ), horizontalAlignment );
        LanguageUtils.registerInitialLanguage ( this, text, data );
        setMargin ( margin );
    }

    /**
     * Constructs label with the specified preferences.
     *
     * @param text text or translation key
     * @param icon label icon
     */
    public WebLabel ( final String text, final Icon icon )
    {
        super ( LanguageUtils.getInitialText ( text ), icon, LEADING );
        LanguageUtils.registerInitialLanguage ( this, text );
    }

    /**
     * todo This constructor causes compile-time issues on JDK7 and replaced with its simple version.
     * todo Reference to the issue: https://github.com/mgarin/weblaf/issues/175
     * todo Return better constructor when fully switched to JDK8+ support only
     */
    //    /**
    //     * Constructs label with the specified preferences.
    //     *
    //     * @param text text or translation key
    //     * @param icon label icon
    //     * @param data language data, may not be passed
    //     */
    //    public WebLabel ( final String text, final Icon icon, final Object... data )
    //    {
    //        super ( LanguageUtils.getInitialText ( text, data ), icon, LEADING );
    //        LanguageUtils.registerInitialLanguage ( this, text, data );
    //    }

    /**
     * Constructs label with the specified preferences.
     *
     * @param text   text or translation key
     * @param icon   label icon
     * @param margin label margin
     * @param data   language data, may not be passed
     */
    public WebLabel ( final String text, final Icon icon, final Insets margin, final Object... data )
    {
        super ( LanguageUtils.getInitialText ( text, data ), icon, LEADING );
        LanguageUtils.registerInitialLanguage ( this, text, data );
        setMargin ( margin );
    }

    /**
     * Constructs label with the specified preferences.
     *
     * @param text                text or translation key
     * @param icon                label icon
     * @param horizontalAlignment horizontal alignment
     * @param data                language data, may not be passed
     */
    public WebLabel ( final String text, final Icon icon, final int horizontalAlignment, final Object... data )
    {
        super ( LanguageUtils.getInitialText ( text, data ), icon, horizontalAlignment );
        LanguageUtils.registerInitialLanguage ( this, text, data );
    }

    /**
     * Constructs label with the specified preferences.
     *
     * @param text                text or translation key
     * @param icon                label icon
     * @param horizontalAlignment horizontal alignment
     * @param margin              label margin
     * @param data                language data, may not be passed
     */
    public WebLabel ( final String text, final Icon icon, final int horizontalAlignment, final Insets margin, final Object... data )
    {
        super ( LanguageUtils.getInitialText ( text, data ), icon, horizontalAlignment );
        LanguageUtils.registerInitialLanguage ( this, text, data );
        setMargin ( margin );
    }

    /**
     * Returns label margin.
     *
     * @return label margin
     */
    public Insets getMargin ()
    {
        return getWebUI ().getMargin ();
    }

    /**
     * Sets label margin.
     *
     * @param margin new label margin
     * @return this label
     */
    public WebLabel setMargin ( final Insets margin )
    {
        getWebUI ().setMargin ( margin );
        return this;
    }

    /**
     * Sets label margin.
     *
     * @param top    top label margin
     * @param left   left label margin
     * @param bottom bottom label margin
     * @param right  right label margin
     * @return this label
     */
    public WebLabel setMargin ( final int top, final int left, final int bottom, final int right )
    {
        setMargin ( new Insets ( top, left, bottom, right ) );
        return this;
    }

    /**
     * Sets label margin.
     *
     * @param spacing label margin
     * @return this label
     */
    public WebLabel setMargin ( final int spacing )
    {
        return setMargin ( spacing, spacing, spacing, spacing );
    }

    /**
     * Returns label painter.
     *
     * @return label painter
     */
    public Painter getPainter ()
    {
        return StyleManager.getPainter ( this );
    }

    /**
     * Sets label painter.
     * Pass null to remove label painter.
     *
     * @param painter new label painter
     * @return this label
     */
    public WebLabel setPainter ( final Painter painter )
    {
        StyleManager.setCustomPainter ( this, painter );
        return this;
    }

    /**
     * Returns whether text shade is displayed or not.
     *
     * @return true if text shade is displayed, false otherwise
     */
    public boolean isDrawShade ()
    {
        return getWebUI ().isDrawShade ();
    }

    /**
     * Sets whether text shade should be displayed or not.
     *
     * @param drawShade whether text shade should be displayed or not
     */
    public WebLabel setDrawShade ( final boolean drawShade )
    {
        getWebUI ().setDrawShade ( drawShade );
        return this;
    }

    /**
     * Returns text shade color.
     *
     * @return text shade color
     */
    public Color getShadeColor ()
    {
        return getWebUI ().getShadeColor ();
    }

    /**
     * Sets text shade color.
     *
     * @param shadeColor text shade color
     */
    public WebLabel setShadeColor ( final Color shadeColor )
    {
        getWebUI ().setShadeColor ( shadeColor );
        return this;
    }

    /**
     * Returns label transparency.
     *
     * @return label transparency
     */
    public Float getTransparency ()
    {
        return getWebUI ().getTransparency ();
    }

    /**
     * Sets label transparency.
     *
     * @param transparency label transparency
     */
    public WebLabel setTransparency ( final Float transparency )
    {
        getWebUI ().setTransparency ( transparency );
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStyleId ()
    {
        return getWebUI ().getStyleId ();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStyleId ( final String id )
    {
        getWebUI ().setStyleId ( id );
    }

    /**
     * Returns Web-UI applied to this class.
     *
     * @return Web-UI applied to this class
     */
    public WebLabelUI getWebUI ()
    {
        return ( WebLabelUI ) getUI ();
    }

    /**
     * Installs a Web-UI into this component.
     */
    @Override
    public void updateUI ()
    {
        if ( getUI () == null || !( getUI () instanceof WebLabelUI ) )
        {
            try
            {
                setUI ( ( WebLabelUI ) ReflectUtils.createInstance ( WebLookAndFeel.labelUI ) );
            }
            catch ( final Throwable e )
            {
                Log.error ( this, e );
                setUI ( new WebLabelUI () );
            }
        }
        else
        {
            setUI ( getUI () );
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLanguage ( final String key, final Object... data )
    {
        LanguageManager.registerComponent ( this, key, data );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateLanguage ( final Object... data )
    {
        LanguageManager.updateComponent ( this, data );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateLanguage ( final String key, final Object... data )
    {
        LanguageManager.updateComponent ( this, key, data );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeLanguage ()
    {
        LanguageManager.unregisterComponent ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLanguageSet ()
    {
        return LanguageManager.isRegisteredComponent ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLanguageUpdater ( final LanguageUpdater updater )
    {
        LanguageManager.registerLanguageUpdater ( this, updater );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeLanguageUpdater ()
    {
        LanguageManager.unregisterLanguageUpdater ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setPlainFont ()
    {
        return SwingUtils.setPlainFont ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setPlainFont ( final boolean apply )
    {
        return SwingUtils.setPlainFont ( this, apply );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPlainFont ()
    {
        return SwingUtils.isPlainFont ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setBoldFont ()
    {
        return SwingUtils.setBoldFont ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setBoldFont ( final boolean apply )
    {
        return SwingUtils.setBoldFont ( this, apply );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBoldFont ()
    {
        return SwingUtils.isBoldFont ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setItalicFont ()
    {
        return SwingUtils.setItalicFont ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setItalicFont ( final boolean apply )
    {
        return SwingUtils.setItalicFont ( this, apply );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isItalicFont ()
    {
        return SwingUtils.isItalicFont ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setFontStyle ( final boolean bold, final boolean italic )
    {
        return SwingUtils.setFontStyle ( this, bold, italic );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setFontStyle ( final int style )
    {
        return SwingUtils.setFontStyle ( this, style );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setFontSize ( final int fontSize )
    {
        return SwingUtils.setFontSize ( this, fontSize );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel changeFontSize ( final int change )
    {
        return SwingUtils.changeFontSize ( this, change );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFontSize ()
    {
        return SwingUtils.getFontSize ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setFontSizeAndStyle ( final int fontSize, final boolean bold, final boolean italic )
    {
        return SwingUtils.setFontSizeAndStyle ( this, fontSize, bold, italic );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setFontSizeAndStyle ( final int fontSize, final int style )
    {
        return SwingUtils.setFontSizeAndStyle ( this, fontSize, style );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setFontName ( final String fontName )
    {
        return SwingUtils.setFontName ( this, fontName );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFontName ()
    {
        return SwingUtils.getFontName ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPreferredWidth ()
    {
        return SizeUtils.getPreferredWidth ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setPreferredWidth ( final int preferredWidth )
    {
        return SizeUtils.setPreferredWidth ( this, preferredWidth );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPreferredHeight ()
    {
        return SizeUtils.getPreferredHeight ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setPreferredHeight ( final int preferredHeight )
    {
        return SizeUtils.setPreferredHeight ( this, preferredHeight );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMinimumWidth ()
    {
        return SizeUtils.getMinimumWidth ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setMinimumWidth ( final int minimumWidth )
    {
        return SizeUtils.setMinimumWidth ( this, minimumWidth );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMinimumHeight ()
    {
        return SizeUtils.getMinimumHeight ( this );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebLabel setMinimumHeight ( final int minimumHeight )
    {
        return SizeUtils.setMinimumHeight ( this, minimumHeight );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension getPreferredSize ()
    {
        return SizeUtils.getPreferredSize ( this, super.getPreferredSize () );
    }
}